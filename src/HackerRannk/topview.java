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
class QueuePack {
	int level;
	Node node;
	public QueuePack(int level, Node node) {
		this.level = level;
		this.node = node;
	}
}

class topview {
	
	static void topView(Node root) {
     	TreeMap<Integer,Integer> ht = new TreeMap<>();
      	if (root == null)
      		return;
      	Queue<QueuePack> queue= new LinkedList<>();
      	queue.add(new QueuePack(0, root));
      	while (!queue.isEmpty()) {
      		QueuePack q = queue.remove();
      		Node n = q.node;
      		int lvl = q.level;

      		if (!ht.containsKey(lvl)) {
      			System.out.print(n.data + " " + q.level  + " ");
      			ht.put(lvl, n.data);
      		}	
      		if (n.left != null) {      			
      			queue.add(new QueuePack(lvl+1, n.left));
      		}
      		if (n.right != null){
      		 	queue.add(new QueuePack(lvl-1, n.right));
      		}
      		System.out.println();
      	}
      	
      	System.out.println();
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
        int[] d = {1,2,5,3,4,6};
        //int[] d = {1,5,3,2,4,6};
        
        // Node root = null;
        // for (int i = 0; i < d.length; i++) {
        // 	root = insert(root, d[i]);
        // }

        Node root = new Node(1);
        root.right = new Node(5);
        root.right.left = new Node(3);
        root.right.right = new Node(6);
        root.right.left.left = new Node(2);
        root.right.left.right = new Node(4);
        
        topView(root);
    }
}



/*
void topView(Node root) {
  
    TreeMap<Integer,Integer> ht = new TreeMap<>();
  	if (root == null)
  		return;
  	Queue<QueuePack> queue= new LinkedList<>();
  	queue.add(new QueuePack(0, root));
  	while (!queue.isEmpty()) {
  		QueuePack q = queue.remove();
  		Node n = q.node;
  		int lvl = q.level;

  		if (!ht.containsKey(lvl)) {
  			System.out.print(n.data + " ");
  			ht.put(lvl, n.data);
  		}	
  		if (n.left != null) {      			
  			queue.add(new QueuePack(lvl+1, n.left));
  		}
  		if (n.right != null){
  		 	queue.add(new QueuePack(lvl-1, n.right));
  		}
  	}
  	
   
}

class QueuePack {
	int level;
	Node node;
	public QueuePack(int level, Node node) {
		this.level = level;
		this.node = node;
	}
}

*/