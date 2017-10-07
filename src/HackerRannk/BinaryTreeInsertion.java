import java.util.*;
import java.io.*;

class Node {
	Node left;
	Node right;
	int data;

	Node (int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
class BinaryTreeInsertion {
	static void levelOrder(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			System.out.print(n.data + " ");
			if (n.left != null) {
				queue.add(n.left);
			}
			if (n.right != null) {
				queue.add(n.right);
			}
		}
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}else {
			if (data <= root.data) {
				root.left = insert(root.left, data);
			}else {
				root.right = insert(root.right, data);
			}
			return root;
		}
	}

	public static void main(String[] args) {
		int[] d = {4,2,7,1,3,6};
    // int[] d = {1,2,5,3,6,4};
		// int[] d = {3,2,5,1,4,6,7};
		Node root = null;
		for (int i = 0; i < d.length; i++) {
			root = insert(root, d[i]);
		}
		levelOrder(root);
	}
}
