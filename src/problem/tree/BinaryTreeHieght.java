package problem.tree;

import problem.tree.VerticalOrderTraversal.Node;

public class BinaryTreeHieght {

	static class Node {
		public Node left;
		public Node right;
		private Integer data;
		public Node(int data){
			this.data = data;
			left = null;
			right = null;
					
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 
        root.right.left.right = new Node(8); 
        root.right.right.right = new Node(9); 
        
        System.out.println(height(root));
	}
	public static int height(Node root){
		int ht;
		if(root == null){
			return -1;
		}
		int lht = height(root.left) +1 ;
		int rht = height(root.right) +1;
		if(lht > rht){
			ht = lht;
		}else{
			ht = rht;
		}
		
		return ht;
	}

}
