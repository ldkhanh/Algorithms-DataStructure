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



class HeightBinaryTree {
	static class QueuePack {
		int level;
		Node node;
		public QueuePack(int level, Node node) {
			this.level = level;
			this.node = node;
		}
	}
	static void HeightBinaryTree(Node root) {
		if (root == null)
			return;
		Queue<QueuePack> queue = new LinkedList<>();
		queue.add(new QueuePack(0,root));
		while (!queue.isEmpty()) {
			QueuePack q = queue.remove();
			Node n = q.node;
			int lvl = q.level;

			System.out.print(n.data + " " + q.level + " ");
			if (n.left != null) {
				queue.add(new QueuePack(lvl + 1, n.left));
			}
			if (n.right != null) {
				queue.add(new QueuePack(lvl + 1, n.right));
			}
			System.out.println();
		}
		System.out.println();
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

		HeightBinaryTree(root);
	}
}















