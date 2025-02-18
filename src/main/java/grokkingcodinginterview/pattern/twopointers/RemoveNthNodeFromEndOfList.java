package grokkingcodinginterview.pattern.twopointers;

public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		int[] a = { 23, 28, 10, 5, 67, 39, 70, 28, 99, 100 };
		LinkedList<Integer> list = new LinkedList<>();
		list.createLinkedList(a);
		System.out.println(list);
		System.out.println("size=" + list.size());

		int n = 3;
//		removeNthLastNode(list.head, n);
		System.out.println("Result-------------------------------------");
		removeNthLastNode(list.head, 3);
		System.out.println(list);
	}

	public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
		LinkedListNode left = head;
		LinkedListNode right = head;

		for (int i = 0; i <= n; i++) {
			right = right.next;
		}

		while (right != null) {
			left = left.next;
			right = right.next;
		}
		// now left.next is the target node
		left.next = left.next.next;
		return head;
	}
}

class LinkedListNode {
	public int data;
	public LinkedListNode next;

	public LinkedListNode(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "LinkedListNode [data=" + data + "]";
	}
	
}

class LinkedList<T> {
	public LinkedListNode head;

	// constructor will be used to make a LinkedList type object
	public LinkedList() {
		this.head = null;
	}

	// insertNodeAtHead method will insert a LinkedListNode at head
	// of a linked list.
	public void insertNodeAtHead(LinkedListNode node) {
		if (this.head == null) {
			this.head = node;
		} else {
			node.next = this.head;
			this.head = node;
		}
	}

	// createLinkedList method will create the linked list using the
	// given integer array with the help of InsertAthead method.
	public void createLinkedList(int[] lst) {
		for (int i = lst.length - 1; i >= 0; i--) {
			LinkedListNode newNode = new LinkedListNode(lst[i]);
			insertNodeAtHead(newNode);
		}
	}
	
	public int size() {
		int count = 0;
		LinkedListNode current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	@Override
	public String toString() {
		LinkedListNode current = head;
		String s = "";
		while (current != null) {
			s += current.data + " ";
			current = current.next;
		}
		return s;
	}

}