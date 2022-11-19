import java.util.Scanner;

public class main {

    public static void main(String[] args){

        createStory();
    }

    public static void createStory(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the First initial story");
        String str = sc.nextLine();
        Node initNode = new Node(str, null);


    }

}