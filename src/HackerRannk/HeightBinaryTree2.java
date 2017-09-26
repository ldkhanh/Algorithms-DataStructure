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

class Solution {
	static class QueuePack {
        int level;
        Node node;
        public QueuePack(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }
	static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lvl = 0;
      	Queue<QueuePack> queue = new LinkedList<>();
        queue.add(new QueuePack(0,root));
        while (!queue.isEmpty()) {
            QueuePack q = queue.remove();
            Node n = q.node;
            lvl = q.level;
            if (n.left != null)
                queue.add(new QueuePack(lvl+1, n.left));
            if (n.right != null)
                queue.add(new QueuePack(lvl+1, n.right));
        }
        return lvl;
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
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0){
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}