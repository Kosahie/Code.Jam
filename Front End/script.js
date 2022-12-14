// Adapted code from https://codepen.io/ross-angus/pen/VwLWqdL
var root         = document.documentElement,
    toolBar      = document.querySelector('[role="toolbar"]'),
    textBar      = document.querySelector('[role="story"]'),
    gutterInput  = document.querySelector('#gutter'),
    alertRoot    = document.querySelector('[data-js="deleteNode"] .root'),
    alertConfirm = document.querySelector('[data-js="deleteNode"] .confirm');
    
var selectedNodeAction;
var selectedNodeStory;

// All the button and body clicks are intercepted here.
document.addEventListener('click', function (e) {
  var clickType = e.target.getAttribute('data-js');
  // User has selected a node
  if (clickType === 'node') {
    selectNode(e);
  } else if (clickType !== '' && clickType !== null) {
    // Buttons within the toolbar, at the top of the page
    if (clickType === 'editName')            editName();
    else if (clickType === 'deleteNode')     deleteNode(e);
    else if (clickType === 'addChild')       addChild();
    else if (clickType === 'addStory')       addStory();
    else if (clickType === 'addAction')      addAction();
    else if (clickType === 'save')           save();
  } else {
    // User has clicked outside of a node
    deselectNodes();
    hideToolbar();
    hideStory();
  }
});

// Allows the user to reorder the tree with the keyboard
root.addEventListener('keydown', function (e) {
  var keyPress;
  // New method vs. old method
  if (e.key) keyPress = e.key;
  else       keyPress = e.which;
  // If the user is editing a node name, they might need to use the arrow keys As God Intended
  if (e.target.getAttribute('contenteditable')) {
    if (keyPress === ' ' || keyPress === '32') {
      insertTextAtCursor(' ');
    }
  }
  // This is useful whether the user is editing the button or not
  if (keyPress === 'ArrowDown' || keyPress === '40') {
    addChild();
  }
});

// Deselects all other nodes, selects the current node and hoyks in the toolber
function selectNode(e) {
  var clicker = e.target;
  // Hang on - do we need to do anything?
  if (clicker.getAttribute('aria-pressed') === 'false') {
    deselectNodes();
    clicker.setAttribute('aria-pressed', 'true');
    clicker.classList.add('selected');
    showToolbar();   
    showStory();
    selectedNodeAction.value = document.getElementById("action").value;
    selectedNodeStory.value = document.getElementById("story").value;
  }
}

// Bit of cleanup, after the user has finished editing the tree.
function deselectNodes() {
  // This needs to run from scratch as new nodes might have been added
  var selectedBtns = [...document.querySelectorAll('.tree [aria-pressed="true"]')],
      btnDelete = document.querySelector('[data-js="deleteNode"]'),
      editBtns = [...document.querySelectorAll('.tree [contenteditable]')];
  // I mean, in theory, there should only be one selected button, but, you know, bugs...
  for (var i = 0; i < selectedBtns.length; i++) {
    selectedBtns[i].setAttribute('aria-pressed', 'false');
    selectedBtns[i].classList.remove('selected');
  }
  // Bit of cleanup, in case the user noped out of deleting a node
  if (btnDelete.classList.contains('js-confirm')) {
    btnDelete.classList.remove('js-confirm');
    alertConfirm.setAttribute('aria-hidden','true');
  }
  if (btnDelete.classList.contains('js-root')) {
    btnDelete.classList.remove('js-root');
    alertRoot.setAttribute('aria-hidden','true');
  }
  // Checks for new nodes which are editable, then turns them off.
  for (var i = 0; i < editBtns.length; i++) {
    editBtns[i].removeAttribute('contenteditable');
  }
}

function showToolbar() {
  toolBar.removeAttribute('aria-hidden');
  toolBar.classList.add('show');
}

function showStory() {
  textBar.removeAttribute('aria-hidden');
  textBar.classList.add('show');
  var chosenChild = document.querySelector('.tree .selected');
  if(!chosenChild.querySelector('input')){
    var input = document.createElement("input");
    input.type = "hidden";
    input.className = "input"; // set the CSS class
    chosenChild.appendChild(input); // put it into the DOM
  }
  document.getElementById("story").value = chosenChild.querySelector('input').value;
  document.getElementById("action").value = chosenChild.value;
  selectedNodeAction = chosenChild;
  selectedNodeStory = chosenChild.querySelector('input');
}

function hideToolbar() {
  toolBar.setAttribute('aria-hidden','true');
  toolBar.classList.remove('show');
}

function hideStory() {
  textBar.setAttribute('aria-hidden','true');
  textBar.classList.remove('show');
}

// Allows the user to rename existing nodes
function editName() {
  var chosenChild = document.querySelector('.tree .selected');
  chosenChild.setAttribute('contenteditable', 'true');
  chosenChild.focus();
}

// Removes the node and it's children
function deleteNode(e) {
  var chosenChild  = document.querySelector('.tree .selected'),
      delButton    = e.target,
      isRoot       = chosenChild.parentNode.parentNode.classList.contains('tree');
  
  // Is the user trying to delete the root node?
  if (isRoot) {
    delButton.classList.add('js-root');
    alertRoot.removeAttribute('aria-hidden');
  }
  // Has the user clicked the delete button once already?
  else if (delButton.classList.contains('js-confirm')) {
    // Is there more than one sibling?
    if (chosenChild.parentNode.parentNode.childElementCount > 1) {
      chosenChild.parentNode.remove();
    } else { // Remove the whole list
      chosenChild.parentNode.parentNode.remove();
    }
    deselectNodes();
    hideToolbar();
  } else {
    delButton.classList.add('js-confirm');
    alertConfirm.removeAttribute('aria-hidden');
  }
}

// Adds a new node under the current node
function addChild() {
  if (document.querySelector('.tree .selected')) {
    var chosenNode = document.querySelector('.tree .selected').parentNode,
        listItem = document.createElement('li');
    listItem.innerHTML = '<button type="button" aria-pressed="false" data-js="node" contenteditable="true">' +
      "Enter a title" + '</button>';
    // The current node already has kids
    if (chosenNode.querySelector('ul')) {
      var chosenKids = chosenNode.querySelector('ul');
      chosenKids.appendChild(listItem);
      chosenKids.lastChild.querySelector('button').focus();
    } else { // The current node has no kids
      var newDad = document.createElement('ul');
      newDad.appendChild(listItem);
      chosenNode.appendChild(newDad);
      chosenNode.lastChild.querySelector('button').focus();
    }    
  }
}

// Because each node is a button tag, the space bar event is captured, when the user is editing.
// This is used as a work-around.
function insertTextAtCursor(text) {
  var sel, range;
  if (window.getSelection) {
      sel = window.getSelection();
      if (sel.getRangeAt && sel.rangeCount) {
          range = sel.getRangeAt(0);
          range.deleteContents();
          range.insertNode( document.createTextNode(text) );
      }
  } else if (document.selection && document.selection.createRange) {
      document.selection.createRange().text = text;
  }
}

function save(){
  selectedNodeAction.value = document.getElementById("action").value;
  selectedNodeStory.value = document.getElementById("story").value;
}