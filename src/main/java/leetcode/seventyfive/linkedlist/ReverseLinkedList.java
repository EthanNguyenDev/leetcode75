package leetcode.seventyfive.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<>(5);
        ListNode<Integer> node4 = new ListNode<>(4, node5);
        ListNode<Integer> node3 = new ListNode<>(3, node4);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        ListNode<Integer> head = new ListNode<>(1, node2);
        ListNode.printList(head);

        ListNode newHead = reverseList(head);
        ListNode.printList(newHead);


    }
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null ) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode; // in the last iteration, current == nextNode == null
        }
        return prev;
    }

}

class ListNode<T> {
    T value;
    ListNode<T> next;

    public ListNode() {

    }

    public ListNode(T val) {
        this.value = val;
    }

    public ListNode(T value, ListNode<T> next) {
        this.next = next;
        this.value = value;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "value=" + value +
            '}';
    }
}