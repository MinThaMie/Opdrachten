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
		this.value = val;
		notify();
		unconsumed=true;
	}

	@Override
	public synchronized int getValue() {	
		int result;
		while (!unconsumed) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		result=this.value;
		unconsumed=false;
		notify();
		
		return result;
	}
}
