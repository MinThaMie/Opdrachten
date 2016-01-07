package ss.week7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcatThread extends Thread {
	private static String text = ""; // global variable
	private String toe; // niet static dus deze word nooit overschreven
	private Lock l = new ReentrantLock();

	public ConcatThread(String toeArg) {
		this.toe = toeArg;
	}

	public synchronized void run() {
		text = text.concat(toe);		
	}

	public static void main(String[] args) {
		(new ConcatThread("one;")).start();
		(new ConcatThread("two;")).start();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.getMessage();
		}
		System.out.println(text);

	}
}
