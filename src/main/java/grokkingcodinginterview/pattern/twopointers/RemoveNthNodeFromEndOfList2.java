package grokkingcodinginterview.pattern.twopointers;

import java.util.Iterator;

public class RemoveNthNodeFromEndOfList2 {
	public static void main(String[] args) throws IllegalAccessException {
		int[] a = { 23, 28, 10, 5, 67, 39, 70, 28, 99, 100 };
		MyLinkedList l = new MyLinkedList();
		l.createFromArray(a);
		
		System.out.println(l + ", n = " + 3);
		removeNthNodeFromTheEnd(l, 3);
		System.out.println("Result---------------------");
		System.out.println(l);
		
		// test case 2
		System.out.println();
		int[] a2 = { 23, 28, 10, 5, 67, 39, 70, 28, 99, 100 };
		MyLinkedList l2 = new MyLinkedList();
		l2.createFromArray(a2);
		
		System.out.println(l2 + ", n = " + 10);
		removeNthNodeFromTheEnd(l2, 10);
		System.out.println("Result---------------------");
		System.out.println(l2);
				
	}
	
	private static Node removeNthNodeFromTheEnd(MyLinkedList l, int n) throws IllegalAccessException {
		Node left = l.head;
		Node right = l.head;
		
		if (n > l.size()) {
			throw new IllegalAccessException("n is greater than list size");
		}
		
		for (int i = 0; i < n; i++) {
			right = right.next;
		}
		
		// when n = size of the list, just remove the head
		if (right == null) {
			Node tmp = l.head.next;
			l.head = tmp;
			return tmp;
		}
		
		while (right.next != null) {
			right = right.next;
			left = left.next;
		}
		
		// now left is just in front of the Node to-be-removed
		Node tmp = left.next;
		left.next = left.next.next;
		return tmp;
		
	}

}

class Node {
	protected int data;
	public Node next;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}

class MyLinkedList {
	protected Node head;
	
	public int size() {
		Node tmp = head;
		int count = 0;
		while (tmp != null) {
			tmp = tmp.next;
			count++;
		}
		return count;
	}
	
	public void addAtTail(int data) {
		Node node = new Node(data);

		if (head == null) {
			head = node;
		} else {
			Node tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = node;

		}
	}

	public void insertAtHead(int data) {
		Node node = new Node(data);
		
		if (head == null) {
			this.head = node;
		} else {
			node.next = this.head;
			this.head = node;
		}
	}

	public void createFromArray(int[] data) throws IllegalAccessException {
		if (data.length == 0) {
			throw new IllegalAccessException("Invalid array");
		}
		
		for (int i = data.length - 1; i >= 0; i--) {
//			Node tmp = new Node(data[i]);
			
			insertAtHead(data[i]);
//			if (head == null) {
//				head = tmp;
//			} else {
//				tmp.next = head;
//				head = tmp;
//			}
		}
	}

	@Override
	public String toString() {
		Node tmp = head;
		String s = "{";
		while (tmp != null) {
			s += tmp.data + ",";
			tmp = tmp.next;
		}
		s = s.substring(0, s.length() - 1);
		s += "}";
		return s;
	}
	
}