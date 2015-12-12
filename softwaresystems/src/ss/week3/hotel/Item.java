package ss.week3.hotel;

public class Item implements Bill.Item {
	//-----------------------------Instance Variables
	private double amount;
	private String name;

	//-----------------------------Constructor
	public Item(String text, double amount) {
		this.amount = amount;
		this.name = text;
	}

	//-----------------------------Queries
	public double getAmount() {
		return this.amount;
	}

	public String toString() {
		return this.name;
	}
	//-----------------------------Commands
}
