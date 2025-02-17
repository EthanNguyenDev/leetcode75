package leetcode.pattern.tree.dfs;

public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> leftSub = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> rightSub = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> leftLeft = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> leftRight = new BinaryTreeNode<>(4);
		BinaryTreeNode<Integer> rightRight = new BinaryTreeNode<>(6);

		root.left = leftSub;
		root.right = rightSub;
		leftSub.left = leftLeft;
		leftSub.right = leftRight;
		rightSub.right = rightRight;
		
		BinaryTreeNode.printPreorder(root);

	}

	public static void flattenTree(BinaryTreeNode<Integer> root) {

	}

	private static BinaryTreeNode<Integer> dfs(BinaryTreeNode<Integer> root) {
		if (root == null)
			return null;

		BinaryTreeNode<Integer> leftTail = dfs(root.left);
		BinaryTreeNode<Integer> rightTail = dfs(root.right);

		if (leftTail != null) {
			leftTail = root.right;
			root.right = root.left;
			root.left = null;
		}

		BinaryTreeNode<Integer> last = null;
		if (rightTail == null) {
			last = leftTail;
		}
		if (leftTail == null) {
			last = root;
		}
		return last;
	}

}

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}

	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public static void printPreorder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.data + ", ");
		printPreorder(root.left);
		printPreorder(root.right);

	}

}
