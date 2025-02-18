package grokkingcodinginterview.pattern.fastslowpointers;

public class MiddleOfLinkedList {
	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8, 10 }; // 6
		LinkedList<Integer> l = new LinkedList<>();
		l.createLinkedList(a);
		System.out.println(l);
		System.out.println(middleNode(l.head));

		int[] b = { 1, 3, 5, 7, 9, 11 }; // 7
		LinkedList<Integer> l2 = new LinkedList<>();
		l2.createLinkedList(b);
		System.out.println(l2);
		System.out.println(middleNode(l2.head));

		int[] c = { 16 }; // 16
		LinkedList<Integer> l3 = new LinkedList<>();
		l3.createLinkedList(c);
		System.out.println(l3);
		System.out.println(middleNode(l3.head));
	}

	public static LinkedListNode middleNode(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next;
			fast = fast.next;

			slow = slow.next;
		}

		return slow;
	}
}
