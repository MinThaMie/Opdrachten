package ss.week7.account;

public class AccountSync {
	static MyThread thread1;
	static MyThread thread2;
	static Account acc;
	static double theAmount = 10;
	static int theTimes = 10000;

	public static void main(String[] args) {
		acc = new Account();
		thread1 = new MyThread(theAmount, theTimes, acc);
		thread2 = new MyThread(-theAmount, theTimes, acc);
		
		thread1.start();
		thread2.start();
		
		try{
			thread1.join();
			thread2.join();
		}catch(InterruptedException e){
			e.getMessage();
		}
System.out.println(acc.getBalance());
	}
	//-----------------------------Instance Variables

	//-----------------------------Constructor

	//-----------------------------Queries

	//-----------------------------Commands
}
