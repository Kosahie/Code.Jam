import java.util.Arrays;
import java.util.List;

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
		resolutionTwo.setBody(
				"He reaches you and you punch him in the face. He gets upset, he was trying just to give you a juice box. You feel bad.");

		// make and add actions
		Action flight = new Action("run", resolutionOne);
		Action fight = new Action("fight", resolutionTwo);
		Action freeze = new Action("do nothing", testNode);
		testNode.addAction(flight);
		testNode.addAction(fight);
		testNode.addAction(freeze);
		testStory.setStart(testNode);

		// setup: create a testing hard coded story
		Story cave = new Story();
		cave.setTitle("The Hobbit.");

		// make starting nodes
		Node start = new Node();
		start.setBody(
				"You open your eyes. It is just as dark as with them shut! You wave your hands in front of your face, but you cannot see anything.");

		// make body nodes
		Node ring = new Node();
		ring.setBody("You feel something in the sand. Its a ring!");
		Node water = new Node();
		water.setBody("Suddenly, you step into icy water.");
		Node noise = new Node();
		noise.setBody(
				"Two glowing eyes appear in the distance, roused by the noise you made. \"What's this?\" says the creature, \"What's this, my precious?\"");
		Node pocket = new Node();
		pocket.setBody("You slip the ring into your pocket.");
		Node wearRing = new Node();
		wearRing.setBody("You slip the ring on your finger.");
		Node surroundings = new Node();
		surroundings.setBody(
				"In the distance, you notice two glowing eyes, moving towards you. \"What's this?\" says the creature, \"What's this, my precious?\"");
		Node nothingNoRing = new Node();
		nothingNoRing.setBody("You feel a light breeze in the distance.");
		Node nothingWithRing = new Node();
		nothingWithRing.setBody("You feel a light breeze in the distance.");
		Node escape = new Node();
		escape.setBody(
				"You find a path that leads you out of the dark cave into a dim, large cavern. \r\nYou see the exit, but there are goblins everywhere! Luckily, they do not see you as escape. \r\nCongratulations! You rejoin your group and continue on your adventure.");
		Node falseEscape = new Node();
		falseEscape.setBody(
				"You find a path that leads you out of the dark cave into a dim, large cavern. \r\nYou see the exit, but there are goblins everywhere! One of them captures you as you try to escape.");
		Node golumn = new Node();
		golumn.setBody(
				"\"It wants to know our name, my precious. But what is it?\" The creature is getting very close. \"Is it tasty? Is it scrumptious?\"");
		Node death = new Node();
		death.setBody("Something grabs you! You meet a brutal but short end in the dark cave.");
		Node stalling = new Node();
		stalling.setBody(
				"You think frantically, and decide to challenge the creature to a match of riddles. It agrees, and starts the match. "
						+ "\n \"What has roots as nobody sees,\r\n" + "Is taller than trees,\r\n"
						+ "Up, up it goes,\r\n" + "And yet never grows?\"");
		Node answered1 = new Node();
		answered1.setBody("You answered correctly. The creature looks dissapointed.");
		Node answered2 = new Node();
		answered2.setBody("The creature is moving closer. You answered correctly again, but he is getting restless.");
		Node answered3 = new Node();
		answered3.setBody("The creature is very close, you can feel his breathing in the still air. You answered correctly again.");
		Node riddle2 = new Node();
		riddle2.setBody("The creature answers your question right. Now its your turn again. \r\n "
				+ "\"Voiceless it cries,\r\n" + "Wingless flutters,\r\n" + "Toothless bites,\r\n" + "Mouthless mutters.\"");
		Node riddle3 = new Node();
		riddle3.setBody("The creature answers your question right. He asks you \"It cannot be seen, cannot be felt,\r\n"
				+ "Cannot be heard, cannot be smelt.\r\n"
				+ "It lies behind stars and under hills,\r\n"
				+ "And empty holes it fills.\r\n"
				+ "It comes out first and follows after,\r\n"
				+ "Ends life, kills laughter.\"");

		// make actions
		Action look = new Action("look around", surroundings, Arrays.asList("look"));
		Action feel = new Action("wave around your arms", ring, Arrays.asList("wave arms","wave my arms","wave"));
		Action walk = new Action("walk forward", water,Arrays.asList("walk","go forward"));
		Action walkFurther = new Action("walk forward", death,Arrays.asList("walk","go forward"));
		Action leap = new Action("leap back", noise,Arrays.asList("leap","jump back"));
		Action standNoRing = new Action("do nothing", nothingNoRing,Arrays.asList("freeze","stand still","nothing"));
		Action standWithRing = new Action("do nothing", nothingWithRing,Arrays.asList("freeze","stand still","nothing"));
		Action putAway = new Action("put the ring in your pocket", pocket,Arrays.asList("pocket","put ring in pocket","put the ring in my pocket"));
		Action putOn = new Action("put on the ring", wearRing,Arrays.asList("put on ring","put on","wear ring"));
		Action takeOff = new Action("take off the ring", pocket,Arrays.asList("take off ring","take off","take ring off"));
		Action demand = new Action("ask the creature's name", golumn,Arrays.asList("ask","ask name","name"));
		Action followNoRing = new Action("follow the breeze", falseEscape,Arrays.asList("follow","follow breeze","breeze"));
		Action followWithRing = new Action("follow the breeze", escape,Arrays.asList("follow","follow breeze","breeze"));
		Action insult = new Action("insult him", death,Arrays.asList("insult"));
		Action stall = new Action("stall", stalling,Arrays.asList("stall him","stall it"));
		Action correct1 = new Action("answer right", answered1,Arrays.asList("mountain","mountains","the mountains"));
		correct1.removeIdentifier("answer right");
		Action correct2 = new Action("answer right", answered2,Arrays.asList("wind","the wind"));
		correct1.removeIdentifier("answer right");
		Action correct3 = new Action("answer right", answered3,Arrays.asList("dark","the dark"));
		correct1.removeIdentifier("answer right");
		Action ask1 = new Action("ask a riddle", riddle2,Arrays.asList("ask","riddle"));
		Action ask2 = new Action("ask a riddle", riddle3,Arrays.asList("ask","riddle"));
		Action ask3 = new Action("ask a riddle", death,Arrays.asList("ask","riddle"));
		Action incorrect = new Action("answer wrong", death,Arrays.asList("wrong","incorrect"));
		Action runNoRing = new Action("run away", falseEscape,Arrays.asList("run","flee"));
		Action runGolumnClose = new Action("run away", death,Arrays.asList("run","flee"));
		Action runWithRing = new Action("run away", escape,Arrays.asList("run","flee"));
		
		// assign actions
		start.addAction(look);
		start.addAction(feel);
		start.addAction(walk);
		start.addAction(standNoRing);
		water.addAction(leap);
		water.addAction(walkFurther);
		noise.addAction(demand);
		noise.addAction(standNoRing);
		noise.addAction(insult);
		pocket.addAction(putOn);
		pocket.addAction(walk);
		pocket.addAction(standNoRing);
		ring.addAction(putAway);
		ring.addAction(putOn);
		ring.addAction(standNoRing);
		nothingNoRing.addAction(followNoRing);
		nothingNoRing.addAction(feel);
		nothingNoRing.addAction(walk);
		nothingWithRing.addAction(followWithRing);
		surroundings.addAction(demand);
		surroundings.addAction(insult);
		surroundings.addAction(standNoRing);
		wearRing.addAction(standWithRing);
		wearRing.addAction(takeOff);
		golumn.addAction(insult);
		golumn.addAction(stall);
		stalling.addAction(incorrect);
		stalling.addAction(correct1);
		riddle2.addAction(incorrect);
		riddle2.addAction(correct2);
		riddle3.addAction(incorrect);
		riddle3.addAction(correct3);
		answered1.addAction(ask1);
		answered2.addAction(ask2);
		answered3.addAction(ask3);
		answered1.addAction(runNoRing);
		answered2.addAction(runWithRing);
		answered3.addAction(runGolumnClose);

		String requestedTitle = "";

		// check for an argument
		if (args.length > 0) {
			requestedTitle = args[0];
		}

		// read the story
		cave.setStart(start);
		cave.read();
	}

	public static void createStory() {
		System.out.println("Start of create story");
		Node initNode = new Node();
	}

}