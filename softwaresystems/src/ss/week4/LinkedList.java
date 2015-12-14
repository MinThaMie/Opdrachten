package ss.week4;

public class LinkedList<Element> {

	private /*@ spec_public @*/ int size;
	private Node first;

	//@ ensures \result.size == 0;
	public LinkedList() {
		size = 0;
		first = null;
	}

	public void add(int index, Element element) {
		Node newNode = new Node(element);
		if (index == 0) {
			newNode.next = first;
			first = newNode;
		} else {
			Node p = getNode(index - 1);
			newNode.next = p.next;
			p.next = newNode;
		}
		size = size + 1;
	}

	//@ ensures this.size == \old(size) - 1;
	public void remove(Element element) {
		if (element == get(0)) {
			first = first.next;
		} else {
			Node p = findBefore(element);
			p.next = p.next.next;
		}
		size--;
	}
	///kan sneller   
	/*	public Node findBefore(Element element) {
			int index = 0;
			Node result;
			while (get(index) != element && index < this.size) {
				index++;
			}
			if (index == 0)
				result = null;
			else
				result = getNode(index - 1);
			return result;
		}*/

	public Node findBefore(Element element) {
		Node p = first;
		int count = 0;

		while (count < (size - 2)) {
			if (p.next.element.equals(element))
				break;
			else {
				p = p.next;
				count++;
			}
		}
		if (p.next.element != element)
			p = null;
		return p;
	}

	//@ requires 0 <= index && index < this.size();
	public Element get(int index) {
		Node p = getNode(index);
		return p.element;
	}

	//@ requires 0 <= i && i < this.size();
	private /*@ pure @*/ Node getNode(int i) {
		Node p = first;
		int pos = 0;
		while (pos != i) {
			p = p.next;
			pos = pos + 1;
		}
		return p;
	}

	//@ ensures \result >= 0;
	public /*@ pure @*/ int size() {
		return size;
	}

	public class Node {
		private Element element;
		public Node next;

		public Node(Element element) {
			this.element = element;
			this.next = null;
		}

		public Element getElement() {
			return element;
		}
	}
}
