package ss.week1;

public class Counter {
	// ---------------------------Instance Variables
	public int dollars;
	public int cents;

	// ---------------------------Constructor
	public Counter() {
	}

	// ---------------------------Queries
	public String getMoney() {
		return ("You now have: " + dollars + "," + cents);
	}

	public int dollars() {
		return dollars;
	}

	public int cents() {
		return cents;
	}


	// ---------------------------Commands
	public void add(int dollarsToAdd, int centsToAdd) {
		dollars = dollars +dollarsToAdd;
		cents = cents + centsToAdd;
		
		dollars=dollars+(cents/100);
		cents=cents%100;
		
	}

	
	public void reset() {
		dollars = 0;
		cents = 0;
	}

}
