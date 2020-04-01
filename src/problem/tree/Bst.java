package problem.tree;

public class Bst {
	
	
	
	class Node 
	{ 
	    int data; 
	    Node left, right; 
	  
	    public Node(int item) 
	    { 
	        data = item; 
	        left = right = null; 
	    } 
	} 
	
	public static boolean isBsTree(Node root){
		return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	
	private static boolean isBst(Node root, int min, int max){
		if(root == null){
			return true;
		}
		if(root.data < min || root.data > max){
			return false;
		}
		return (isBst(root.left, min, root.data -1) &&  isBst(root.right, root.data + 1, max));
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}

}
