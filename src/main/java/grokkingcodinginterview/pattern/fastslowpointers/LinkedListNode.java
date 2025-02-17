package grokkingcodinginterview.pattern.fastslowpointers;

class LinkedListNode {
	public int data;
	public LinkedListNode next;

	// Constructor will be used to make a LinkedListNode type object
	public LinkedListNode(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "LinkedListNode [data=" + data + "]";
	}

}