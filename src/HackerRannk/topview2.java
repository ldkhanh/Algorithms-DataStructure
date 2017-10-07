import java.util.*;
import java.io.*;
class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class topview2 {
	
	static void topView(Node root) {
     	if (root == null)
        return;
      Node curr = root;
      Stack<Node> st = new Stack<Node>();
      while (curr != null) {
        System.out.println("Push="+curr.data);
        st.push(curr);
        curr = curr.left;
      }
      while (!st.isEmpty()) {
        Node n = st.pop();
        System.out.print(n.data+ " ");
      }
      curr = root.right;
      while( curr != null) {
        System.out.print(curr.data + " ");
        curr = curr.right;
      }
    }

    public static Node insert(Node root, int data) {
        if(root == null){
            return new Node(data);
        }
        else {
            Node cur;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else{
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
    public static void main(String[] args) {
        //int[] d = {1,0,2,5,3,4,6};
        int[] d = {1,2,5,3,6,4};
        
        Node root = null;
        for (int i = 0; i < d.length; i++) {
        	root = insert(root, d[i]);
        }
        // Node root = new Node(1);
        // root.right = new Node(5);
        // root.right.left = new Node(3);
        // root.right.right = new Node(6);
        // root.right.left.left = new Node(2);
        // root.right.left.right = new Node(4);
        
        topView(root);
    }
}