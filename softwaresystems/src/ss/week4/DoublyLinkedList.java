package ss.week4;

public class DoublyLinkedList<Element> {

	private /*@ spec_public @*/ int size;
	private Node head;

	//@ ensures this.size == 0;
	public DoublyLinkedList() {
		size = 0;
		head = new Node(null);
		head.next = head;
		head.previous = head;
	}

	//@ requires element != null;
	//@ requires 0 <= index && index <= this.size;
	//@ ensures this.size == \old(size) + 1;
	//@ ensures this.getNode(index).equals(element);
	public void add(int index, Element element) {
		this.size++;
		
		Node node = new Node(element);
		node.next = getNode(index);
		node.previous = node.next.previous;
		(node.previous).next=node;		
		(node.next).previous=node;
	}

	//@ requires 0 <= index && index < this.size;
	//@ ensures this.size == \old(size) - 1;
	public void remove(int index) {
		Node node=getNode(index);
		node.previous.next=node.next;
		node.next.previous=node.previous;
		node.next=node;
		node.previous=node;
		size--;
	}

	//@ requires 0 <= index && index < this.size;
	/*@ pure */ public Element get(int index) {
		Node p = getNode(index);
		return p.element;
	}

	/**
	 * The node containing the element with the specified index. The head node
	 * if the specified index is -1.
	 */
	//@ requires -1 <= i && i < this.size;
	//@ pure
	public Node getNode(int i) {
		Node p = head;
		int pos = -1;
		while (pos < i) {
			p = p.next;
			pos = pos + 1;
		}
		return p;
	}

	public int size() {
		return this.size;
	}

	public class Node {
		public Node(Element element) {
			this.element = element;
			this.next = null;
			this.previous = null;
		}

		private Element element;
		public Node next;
		public Node previous;

		public Element getElement() {
			return element;
		}
	}
}
