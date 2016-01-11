package ss.week7.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsoleLock extends Thread {
	//-----------------------------Instance Variables
	static final Lock l = new ReentrantLock();
	//-----------------------------Constructor
	public TestSyncConsoleLock(String name) {
		super(name);
		
	}

	public static void main(String[] args) {
		(new TestSyncConsoleLock("A")).start();
		(new TestSyncConsoleLock("B")).start();
	}

	//-----------------------------Queries

	//-----------------------------Commands
	private void sum() {		
		l.lock();
		int number1 = SyncConsole.readInt("Thread: " + this.getName() + " input integer 1 ");
		int number2 = SyncConsole.readInt("Thread: " + this.getName() + " input integer 2 ");

		SyncConsole.println(number1 + " + " + number2 + " = " + (number1 + number2));
		l.unlock();
	}

	public void run() {
		sum();
	}
}
