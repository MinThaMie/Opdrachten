package ss.week4;

import java.util.*;

public class MergeSort {
	public static <Elem extends Comparable<Elem>>

	void mergesort(List<Elem> list) {
		if (list.size() <= 1) {
			return;
		}

		List<Elem> listLeft = new ArrayList<>(list.subList(0, (list.size() / 2)));
		List<Elem> listRight = new ArrayList<>(list.subList((list.size() / 2), list.size()));

		System.out.println(listLeft);
		System.out.println(listRight);
		
		mergesort(listLeft);
		mergesort(listRight);

		list.clear();
		list.addAll(merge(listLeft, listRight));

		
		System.out.println(list);
		//System.out.println("templist =" + tempList + "list =" + list);
	}

	static public <Elem extends Comparable<Elem>> List<Elem> merge(List<Elem> listLeft, List<Elem> listRight) {
		List<Elem> temp = new ArrayList<>();

		while (!listLeft.isEmpty()&& !listRight.isEmpty()) {
			if (0 > listLeft.get(0).compareTo(listRight.get(0))) {
				temp.add(listLeft.remove(0));
				
			} else {
				temp.add(listRight.get(0));
				listRight.remove(0);
			}

		}
		if (listLeft.isEmpty() && !listRight.isEmpty()) {
			temp.addAll(listRight);
		} else {
			temp.addAll(listLeft);
		}
		return temp;

	}
}
