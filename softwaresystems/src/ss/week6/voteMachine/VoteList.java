package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {
	//-----------------------------Instance Variables
	private Map<String, Integer> votes;

	//-----------------------------Constructor
	public VoteList() {
		votes = new HashMap<String,Integer>();
	}

	//-----------------------------Queries
	public Map<String,Integer> getVotes(){
		
		return this.votes;
	} 

	//-----------------------------Commands
	public void addVote(String party) {
		if (this.votes.containsKey(party)) {
			this.votes.replace(party, this.votes.get(party) + 1);
		} else {
			this.votes.put(party, 1);
		}
		setChanged();
		notifyObservers("vote");
	}
}
