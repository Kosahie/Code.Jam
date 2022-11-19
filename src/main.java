<<<<<<< HEAD
import java.util.Scanner;
=======
import java.util.Scanner; // Import the Scanner class
>>>>>>> dbf1fdcbb2896d0f37e66278e3f95d4a3457e27a

public class main {

	public static void main(String[] args) {

		createStory();
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter username");

<<<<<<< HEAD
    public static void createStory(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the First initial story");
        String str = sc.nextLine();
        Node initNode = new Node(str, null);


    }

=======
		String userName = myObj.nextLine(); // Read user input
		System.out.println("Username is: " + userName); // Output user input
	}

	public static void createStory() {
		System.out.println("Start of create story");
		Node initNode = new Node();
	}

	public 
	
>>>>>>> dbf1fdcbb2896d0f37e66278e3f95d4a3457e27a
}