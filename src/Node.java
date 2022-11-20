import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class

public class Node {

	// attributes
	private String body;
	private List<Action> actions;

	// constructor - initializes a blank list for the arguments
	public Node() {
		this.actions = new ArrayList<>();
	}

	// getters and setters
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public void addAction(Action a) {
		this.actions.add(a);
	}

	public Action removeAction(Action a) {
		if (!this.actions.contains(a))
			throw new NullPointerException("Action not found.");
		this.actions.remove(a);
		return a;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	// methods
	// recursive: this method reads the node, provides the actions possible and then
	// goes to the next node depending on what the user chose
	public void readNode() {

		// read text
		System.out.println(this.body);

		// check if it's an ending
		if (this.actions == null || this.actions.size() == 0) {
			System.out.println("The end.");
		}

		// if not, read the possible actions
		else {

			// set up input prompt
			String prompt = "Do you...";
			for (Action action : this.actions)
				prompt = prompt + " " + action + "?";

			// get user to selection action
			Action chosenAction = new Action();
			boolean found = false;
			while (!found) {
				// ask user what action they will take
				Scanner myObj = new Scanner(System.in);
				System.out.println(prompt);
				String userText = myObj.nextLine(); // Read user input
				userText = userText.toLowerCase();

				// Determine which action was chosen by checking action identifiers
				for (Action a : actions) {
					if (a.getIdentifiers().contains(userText)) {
						chosenAction = a;
						found = true;
						break;
					}
				}
				// ask again if the answer does not match one of the possible actions
				if (!found) System.out.println("Error: please choose one of the listed actions.");
			}
			// read next node
			chosenAction.getNode().readNode();
		}
	}

}