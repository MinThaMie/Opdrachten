package ss.week7.threads;


public class SynchronizedIntCell implements IntCell {
	private boolean unconsumed = false;
	private int value = 0;

	@Override
	public synchronized void setValue(int val) {
		while (unconsumed){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		unconsumed=true;
		this.value = val;
		notify();
	}

	@Override
	public synchronized int getValue() {		
		while (!unconsumed) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		unconsumed=false;
		notify();
		return this.value;
	}
}
