package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.Observable;

public class PartyList extends Observable{
	//-----------------------------Instance Variables
	private ArrayList<String> parties;

	//-----------------------------Constructor
	public PartyList(String[] parties) {
		this.parties = new ArrayList<String>();		
		for (String party : parties) {
			this.parties.add(party);
		}
	}

	public PartyList() {
		this.parties = new ArrayList<String>();
	}
	//-----------------------------Queries
	
	public ArrayList<String> getParties(){
		return this.parties;
	}
	
	public boolean hasParty(String party){
		return this.parties.contains(party);
	}

	//-----------------------------Commands
	public void addParty(String party) {
		if (!this.parties.contains(party)){
		this.parties.add(party);
		setChanged();
		notifyObservers("party");}
		else {
			System.out.println("Party already added");
		}
	}
	


}
