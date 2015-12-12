package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {
	//-----------------------------Instance Variables
	
	private double amount;

	//-----------------------------Constructor
	public PricedRoom(int no, double roomPrice, Safe safe) {
		super(no,safe);
		this.amount = roomPrice;
	}
	
	public PricedRoom(int no, double roomPrice, double safePrice){
		this(no,roomPrice, new PricedSafe(safePrice));
	}

	//-----------------------------Queries
	public double getAmount() {
		return this.amount;

	}

	public String toString() {
		return ("Room: " + this.number + "costs: "+ Double.toString(this.amount));
	}
	//-----------------------------Commands
}
