package grokkingcodinginterview.pattern.fastslowpointers;

public class DetectLinkedListCycle {

	public static void main(String[] args) throws IllegalAccessException {
		int[] a = { 3, 5, 9, 11, 7 }; // assume there's cycle from 7 to 9, TRUE
		LinkedList<Integer> l = new LinkedList<>();
		l.createLinkedList(a);
		System.out.println(l);

		LinkedListNode tail = l.head;
		LinkedListNode cycleNode = l.head;
		while (tail.next != null) {
			tail = tail.next;
		}
		// move 2 times
		for (int i = 0; i < 2; i++) {
			cycleNode = cycleNode.next;
		}
		// now cycleNode is at 9
		tail.next = cycleNode;

//		cannot print any more, because the inner cycle cause infinite loop
//		System.out.println(l);

		// now write program to detect inner cycle
		System.out.println(hasInnerCycle(l.head));

		int[] a2 = { 2, 4, 6, 8, 10 }; // another test case, FALSE
		LinkedList<Integer> l2 = new LinkedList<>();
		l2.createLinkedList(a2);
		System.out.println(l2);
		System.out.println(hasInnerCycle(l2.head));

	}

	static boolean hasInnerCycle(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		do {
			;
			slow = slow.next;

			fast = fast.next;
			fast = fast.next;
		} while (fast != null && fast.next != null && fast != slow);

		return fast == slow;
	}

}
