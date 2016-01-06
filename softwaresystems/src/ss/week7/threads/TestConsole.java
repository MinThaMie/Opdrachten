package ss.week7.threads;

public class TestConsole extends Thread {
	//-----------------------------Instance Variables
	

	//-----------------------------Constructor
	public TestConsole(String name){
		super(name);	
	}
	
	public static void main(String[] args){
		(new TestConsole("A")).start();
		(new TestConsole("B")).start();		
	}

	//-----------------------------Queries
	
		

	//-----------------------------Commands
private void sum(){
int number1 = Console.readInt( "Thread: " + this.getName() +" input integer 1 ");
int number2 = Console.readInt("Thread: " + this.getName() + " input integer 2 ");

Console.println(number1 + " + " + number2 + " = " + (number1+number2));
}
	public void run(){
		sum();		
	}
}
