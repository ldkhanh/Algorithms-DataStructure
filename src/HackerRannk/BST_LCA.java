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
class BST_LCA {
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

  static Node lca(Node root, int v1, int v2) {
    if (root == null)
      return null;
    if (root.data > v1 && root.data > v2)
      return lca(root.left, v1,v2);
    if (root.data < v1 && root.data < v2)
      return lca(root.right, v1, v2);
    return root;
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
		int[] d = {2,1,5,3,6,4};      //binary tree

		Node root = null;
		for (int i = 0; i < d.length; i++) {
			root = insert(root, d[i]);
		}

    levelOrder(root);

    System.out.println("\nLCA of 4 & 6 is: " + lca(root,4,6).data);


	}
}
