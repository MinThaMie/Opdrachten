package ss.week3;

public class Format {

	public static void main(String[] args) {
		//Format();
		printLine("text1", 1);
		printLine("other text", -12.12);
		printLine("something", 0.20);

	}
	//-----------------------------Instance Variables

	//-----------------------------Constructor
	public Format() {
	}
	//-----------------------------Queries

	//-----------------------------Commands
	public static void printLine(String text, double amount) {
		System.out.format("%-15s %8.2f \n", text, amount);
	}
}
