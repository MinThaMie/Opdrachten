package ss.week6.voteMachine;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {
	//-----------------------------Instance Variables
	private PartyList parties;
	private VoteList votes;
	private VoteView view;

	//-----------------------------Constructor
	public VoteMachine() {
		parties = new PartyList();
		votes = new VoteList();
		view = new VoteGUIView(this);
		
		parties.addObserver(view);
		votes.addObserver(view);
	}

	public static void main(String[] args) {
		VoteMachine machine = new VoteMachine();
		machine.start();
	}

	//-----------------------------Queries
	public void getParties() {
		view.showParties(parties.getParties());
	}

	public void getVotes() {
		view.showVotes(votes.getVotes());
	}

	//-----------------------------Commands
	public void start() {
		view.start();
	}

	public void vote(String party) {
		if (parties.getParties().contains(party)) {
			votes.addVote(party);
		} else {
			System.out.print("No such party, add party first \n");
		}
	}

	public void addParty(String party) {
		parties.addParty(party);
	}

}