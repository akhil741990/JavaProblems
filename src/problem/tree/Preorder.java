package problem.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import problem.tree.VerticalOrderTraversal.Node;

public class Preorder {

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
	
	public static void traverse(Node root){
		Stack<Node> s = new Stack<VerticalOrderTraversal.Node>();
		while(root!=null){
			s.push(root);
			System.out.println(root.data);
			root = root.left;
		}
		while(!s.isEmpty()){
			Node next = s.pop().right;
			while(next!=null){
				s.push(next);
				System.out.println(next.data);
				next = next.left;
			}
		}
	}

	public static List<Integer> traverseAndCompute(Node root){
		List<Integer> preorder = new ArrayList<Integer>();
		Stack<Node> s = new Stack<VerticalOrderTraversal.Node>();
		while(root!=null){
			s.push(root);
			System.out.println(root.data);
			preorder.add(root.data);
			root = root.left;
		}
		while(!s.isEmpty()){
			Node next = s.pop().right;
			while(next!=null){
				s.push(next);
				System.out.println(next.data);
				preorder.add(next.data);
				next = next.left;
			}
		}
		return preorder;
	}
}
