package grokkingcodinginterview.pattern.fastslowpointers;

public class PalindromeLinkedlist {
	public static void main(String[] args) {
		int[] a = { 3, 5, 7, 9, 11, 9, 7, 5, 3 }; // TRUE
//		int[] a = { 3, 5, 7, 9, 11, 9, 9, 7, 5, 3 }; // FALSE
//		int[] a = { 3, 5, 7, 9, 11, 11, 9, 7, 5, 3 }; // TRUE
		LinkedList<Integer> l = new LinkedList<>();
		l.createLinkedList(a);

		LinkedListNode tail = reverseSecondHalf(l.head);
		System.out.println(l);
		System.out.println(tail);
		System.out.println(tail.next);
		System.out.println(tail.next.next);

		// now compare first half with 2nd half using 2 pointers
		System.out.println("Is palindrom " + isPalindrome(l.head, tail));

	}

	static boolean isPalindrome(LinkedListNode head, LinkedListNode tail) {
		LinkedListNode firstHalf = head;
		LinkedListNode secondHalf = tail;
		while (firstHalf != null && secondHalf != null) {
			if (firstHalf.data != secondHalf.data) {
				return false;
			}
			firstHalf = firstHalf.next; // going forward
			secondHalf = secondHalf.next; // going backward
		}
		return true;
	}

	static LinkedListNode reverseSecondHalf(LinkedListNode head) {
		if (head == null || head.next == null) {
			return head; // No need to reverse if the list has 0 or 1 element
		}

		// Find the middle of the linked list using fast and slow pointers
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// now, slow is at the middle
		// Reverse the second half of the linked list
		LinkedListNode prev = null;
		LinkedListNode current = slow.next;

		while (current != null) {
			LinkedListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		// at this point, prev is at the end of the list
		slow.next = prev;

		return prev;
	}

}
