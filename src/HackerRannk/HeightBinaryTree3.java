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

class HeightBinaryTree3 {
	
	static int HeightBinaryTree3(Node root) {
		if (root == null)
			return 0;
		if (root != null && root.left == null && root.right == null)
			return 0;
		return 1 + Math.max(HeightBinaryTree3(root.left),HeightBinaryTree3(root.right));
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			}else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		// int[] d = {1,2,5,3,4,6};
		int[] d = {3,2,5,1,4,6,7};

		Node root = null;
		for (int i = 0; i < d.length; i++) {
			root = insert(root, d[i]);
		}

		System.out.println(HeightBinaryTree3(root));
	}
}