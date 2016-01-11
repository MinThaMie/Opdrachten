package ss.week7;

public class SortStarter extends Thread {
	//-----------------------------Instance Variables
	
	private int[] a;
	private int first;
	private int last;
	
	public SortStarter(int[] a, int first,int last){
		this.a=a;
		this.first=first;
		this.last=last;
	}

	public void run(){
	MultiThreadQuickSort.qsort(a, first, last);}
	//-----------------------------Constructor

	//-----------------------------Queries

	//-----------------------------Commands
}
