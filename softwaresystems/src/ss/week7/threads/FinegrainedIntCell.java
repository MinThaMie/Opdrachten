package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {
	private boolean unconsumed = false;
	private int value = 0;
	private final Lock l = new ReentrantLock();
	private final Condition bufferEmpty = l.newCondition();
	private final Condition bufferFull = l.newCondition();

	@Override
	public void setValue(int val) {
		l.lock();
		try {
			while (unconsumed) {
				bufferEmpty.await();
			}
			this.value = val;
			//System.out.println(System.currentTimeMillis());
			unconsumed = true;
			bufferFull.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			l.unlock();
		}
	}

	@Override
	public int getValue() {
		l.lock();
		try {
			while (!unconsumed) {
				bufferFull.await();
			}
			unconsumed = false;
			bufferEmpty.signal();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {			
			l.unlock();			
		}
		//System.out.println(System.currentTimeMillis());
		return this.value;
		
	}
}
