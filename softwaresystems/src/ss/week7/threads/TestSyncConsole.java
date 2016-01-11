package ss.week7.threads;

public class TestSyncConsole extends Thread {
	//-----------------------------Instance Variables

	//-----------------------------Constructor
	public TestSyncConsole(String name) {
		super(name);
	}

	public static void main(String[] args) {
		(new TestSyncConsole("A")).start();
		(new TestSyncConsole("B")).start();
	}

	//-----------------------------Queries

	//-----------------------------Commands
	private synchronized void sum() {
		synchronized (System.in) {
			int number1 = SyncConsole.readInt("Thread: " + this.getName() + " input integer 1 ");
			int number2 = SyncConsole.readInt("Thread: " + this.getName() + " input integer 2 ");

			SyncConsole.println(number1 + " + " + number2 + " = " + (number1 + number2));
		}
	}

	public void run() {
		sum();
	}
}
