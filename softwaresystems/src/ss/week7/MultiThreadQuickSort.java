package ss.week7;

public class MultiThreadQuickSort {

	public static void qsort(int[] a) {
		qsort(a, 0, a.length - 1);
	}


	public static void qsort(int[] a, int first, int last) {
		if (first < last) {
			int position = partition(a, first, last);
			SortStarter een = new SortStarter(a, first, position - 1);			
			SortStarter twee = new SortStarter(a, position + 1, last);
			
			een.start();
			twee.start();
			
			try{
				een.join();
				twee.join();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	public static int partition(int[] a, int first, int last) {

		int mid = (first + last) / 2;
		int pivot = a[mid];
		swap(a, mid, last); // put pivot at the end of the array
		int pi = first;
		int i = first;
		while (i != last) {
			if (a[i] < pivot) {
				swap(a, pi, i);
				pi++;
			}
			i++;
		}
		swap(a, pi, last); // put pivot in its place "in the middle"
		return pi;
	}

	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
