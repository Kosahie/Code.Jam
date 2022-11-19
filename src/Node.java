import java.util.List;
import java.util.Scanner; // Import the Scanner class

public class Node {

	private String body;
	private List<Action> actions;

	public void readNode() {

		// read text
		System.out.println(this.body);

		// set up input prompt
		String prompt = "Do you...";
		for (Action action : this.actions)
			prompt = prompt + " " + action;

		// get user to selection action
		String chosenAction = "";
		while (true) {
			// ask user what action they will take
			Scanner myObj = new Scanner(System.in);
			System.out.println(prompt);
			chosenAction = myObj.nextLine(); // Read user input

			// Determine which action was chosen
			if (!actions.contains(chosenAction))
				break;
			
			// ask again if the answer does not match one of the possible actions
			System.out.println("Error: please choose one of the listed actions.");
		}
		
		for (Action a : actions) if (a.equals(chosenAction)) a.getNode().readNode();
		
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Action> getAction() {
		return action;
	}

	public void setAction(List<Action> action) {
		this.action = action;
	}
}