package ss.week3.hotel;

public class Bill {

	//-----------------------------Instance Variables
	private double sum;
	private java.io.PrintStream theOutStream;
	private String textToPrint;

	public static interface Item {
		public double getAmount();
		public String toString();
	}

	//-----------------------------Constructor
	public Bill(java.io.PrintStream theOutStream) {
		this.theOutStream = theOutStream;
		this.textToPrint = "The sum of the bill is:";
		this.sum = 0;

	}

	//-----------------------------Queries
	public double getSum() {
		return this.sum;
	}

	//-----------------------------Commands
	public void close() {
		if (theOutStream != null)
			theOutStream.format("%30s %10.2f \n", this.textToPrint, getSum());
		this.sum=0;
	}

	public void newItem(Bill.Item item) {
		if (theOutStream != null)
			theOutStream.format("%30s %10.2f \n", item.toString(), item.getAmount());
		this.sum += item.getAmount();
	}
}
