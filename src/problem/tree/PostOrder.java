package problem.tree;

import java.util.Stack;

import problem.tree.VerticalOrderTraversal.Node;

public class PostOrder {

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
        traverse(root);
	}

	public static void traverse(Node root) {

		Stack<Node> s = new Stack<VerticalOrderTraversal.Node>();
		while(root!=null){
			s.push(root);
			root = root.left;
		}
		while(!s.isEmpty()){
			Node next = s.pop();
			if(next.isRightVisted){
				System.out.println(next.data);
			}else{
				next.isRightVisted = true;
				s.push(next);
				next = next.right;
				while(next!=null){
					s.push(next);
					next = next.left;
				}
			}
			
			
		}
	}
	
	

}
