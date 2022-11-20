
public class main {

	public static void main(String[] args) {
		
		// setup: create a testing hard coded story
		Story testStory = new Story();
		testStory.setTitle("The big test.");
		
		// make starting node
		Node testNode = new Node();
		testNode.setBody("An angry man is running at you.");
		
		// make endings
		Node resolutionOne = new Node();
		resolutionOne.setBody("You escape, and live happily ever after.");
		Node resolutionTwo = new Node();
		resolutionTwo.setBody("He reaches you and you punch him in the face. He gets upset, he was trying just to give you a juice box. You feel bad.");
		
		// make and add actions
		Action flight = new Action("run", resolutionOne);
		Action fight = new Action("fight", resolutionTwo);
		Action freeze = new Action("do nothing", testNode);
		testNode.addAction(flight);
		testNode.addAction(fight);
		testNode.addAction(freeze);
		testStory.setStart(testNode);
		
		String requestedTitle = "";
		
		// check for an argument
		if (args.length > 0) {
			requestedTitle = args[0];
		}
		
		// read the story
		testStory.read();
	}

	public static void createStory() {
		System.out.println("Start of create story");
		Node initNode = new Node();
	}

}