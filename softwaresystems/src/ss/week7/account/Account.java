package ss.week7.account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	protected double balance = 0.0;
	protected double minimumBalance = -1000;

	static Lock lock = new ReentrantLock();
//could do without locks, buth had first change with locks and not synchronized
	public synchronized void transaction(double amount) throws InterruptedException {
		while ((this.balance + amount) < this.minimumBalance) {
			wait();
		}
		lock.lock();
		balance = balance + amount;
		lock.unlock();
		notify();
	}

	public double getBalance() {
		return balance;
	}

}
