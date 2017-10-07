/*
* HackerRank Problem
* https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
*/

import java.util.*;
import java.io.*;

class Node {
	public Node left,right;
  public int frequency;
  public char data;
  public Node() {

  }
}

class HuffmanDecoding {
	static void traversal(Node root) {
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
  private static void decode(String S, Node root) {
    String decoded = "";
    Node curr = root;
    for (int i = 0; i < S.length(); i++) {
      char k = S.charAt(i);
      if (k == '0')
        curr = curr.left;
      if (k == '1')
        curr = curr.right;
      if (curr.data != '\0') {
        decoded += curr.data;
        curr = root;
      }
    }
    System.out.println(decoded);
  }

	public static Node insert() {

    Node root = new Node();
    root.data = '\0';
    root.frequency = 5;

    root.left = new Node();
    root.left.data = '\0';
    root.left.frequency = 2;

    root.left.left = new Node();
    root.left.left.data = 'B';
    root.left.left.frequency = 1;
    root.left.left.left = null;
    root.left.left.right = null;

    root.left.right = new Node();
    root.left.right.data = 'C';
    root.left.right.frequency = 1;
    root.left.right.left = null;
    root.left.right.right = null;

    root.right = new Node();
    root.right.data = 'A';
    root.right.frequency = 3;
    root.right.left = null;
    root.right.right = null;
		return root;
	}

	public static void main(String[] args) {
    String S = "1001011";
		Node root =  insert();
    decode(S,root);
		traversal(root);
	}
}
