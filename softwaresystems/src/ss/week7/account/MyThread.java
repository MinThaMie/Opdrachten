package ss.week7.account;

public class MyThread extends Thread{
	//-----------------------------Instance Variables
	private double theAmount;
	private int theTimes;
	private Account theAccount;

	//-----------------------------Constructor
	public MyThread(double amount, int times, Account account) {
		this.theAmount = amount;
		this.theTimes = times;
		this.theAccount = account;
	}

	//-----------------------------Queries

	//-----------------------------Commands
	@Override
	public void run(){
		for (int i=0; i<this.theTimes;i++){
			try {
				theAccount.transaction(theAmount);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
