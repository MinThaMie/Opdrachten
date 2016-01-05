package ss.week6.voteMachine;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class VoteTUIView implements Observer,VoteView {

	private VoteMachine controller;

	public VoteTUIView(VoteMachine vm) {
		controller = vm;
	}

	@Override
	public void start() {
		displayHelp();
		boolean go = true;
		Scanner in = new Scanner(System.in);
		Scanner lineScanner;
		while (go) {
			System.out.println("Enter input");
			String line = in.nextLine();
			lineScanner = new Scanner(line);

			if (line.startsWith("HELP")) {
				displayHelp();
			} else if (line.startsWith("VOTES")) {
				
				controller.getVotes();
			} else if (line.startsWith("VOTE")) {
				lineScanner.next();
				controller.vote(lineScanner.next());
			} else if (line.startsWith("ADD PARTY")) {
				lineScanner.next();
				lineScanner.next();
				controller.addParty(lineScanner.next());
			} else if (line.startsWith("PARTIES")) {
				controller.getParties();
			} else if (line.startsWith("EXIT")) {
				go = false;
			} else {
				System.out.println("This is not a valid command");
				displayHelp();
			}

		}
		in.close();

	}

	private void displayHelp() {
		System.out.println("Possible commands with explanation:");
		System.out.println("VOTE [party]: Places a vote for the given party.");
		System.out.println("ADD PARTY [party]: Adds the party to the list of parties.");
		System.out.println("VOTES: Shows the current vote tally.");
		System.out.println("PARTIES: Shows all the parties of this election.");
		System.out.println("EXIT: Closes the VoteMachine.");
		System.out.println("HELP: Prints this menu.");
	}

	@Override
	public void showVotes(Map<String, Integer> votes) {
		
		for (Map.Entry<String, Integer> entry : votes.entrySet()) {
			System.out.println("party " + entry.getKey() + " has " + entry.getValue() + " votes.");
		}

	}

	@Override
	public void showParties(List<String> parties) {
		for (String party : parties) {
			System.out.println(party);
		}

	}

	@Override
	public void showError(String message) {
		System.err.println(message);

	}

	@Override
	public void update(Observable o, Object arg) {
		
		if (arg.equals("party")) {
			System.out.println("Parties updated.");
		} else if (arg.equals("vote")) {
			System.out.println("Votes updated");
		}
		
	}

}
