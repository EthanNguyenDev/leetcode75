package leetcode.seventyfive.linkedlist;

public class DeleteMiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode<Integer> node6 = new ListNode<>(6);
        ListNode<Integer> node5 = new ListNode<>(2, node6);
        ListNode<Integer> node4 = new ListNode<>(1, node5);
        ListNode<Integer> node3 = new ListNode<>(7, node4);
        ListNode<Integer> node2 = new ListNode<>(4, node3);
        ListNode<Integer> node1 = new ListNode<>(3, node2);
        ListNode<Integer> head = new ListNode<>(1, node1);
        ListNode.printList(head);

//        System.out.println(deleteMiddle(head));
        deleteMiddle(head);
        ListNode.printList(head);
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            fast = fast.next;

            prev = slow;
            slow = slow.next;
        }
        // slow is now at the middle
        ListNode tmp = slow.next;
        prev.next = tmp;
        slow.next = null;

        return head;
    }
}
