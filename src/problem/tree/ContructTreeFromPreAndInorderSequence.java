package problem.tree;

import java.util.List;

import problem.tree.VerticalOrderTraversal.Node;

public class ContructTreeFromPreAndInorderSequence {

	static int preIndex;
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

        List<Integer> iTraversal = Inorder.traverseAndCompute(root);
        Integer[] inorder = new Integer[iTraversal.size()];
        inorder = iTraversal.toArray(inorder);
        List<Integer> preTraversal = Preorder.traverseAndCompute(root);
        Integer[] preorder = new Integer[preTraversal.size()];
        preorder = preTraversal.toArray(preorder);
        preIndex = 0;
        Node newRoot = constructTree(inorder, preorder, 0, inorder.length-1);
        
        System.out.println("=====Tree Contsructed and its Inorder traversal");
        Inorder.traverse(newRoot);
        
	}
	
	public static Node constructTree(Integer [] inorder, Integer[] preorder, int preStart, int inEnd){
		if(preStart >  inEnd){
			return null;
		}
		Node n = new Node(preorder[preIndex++]);
		if(preStart == inEnd){
			return n;
		}
		
		int index = searchInOrderChar(inorder,preStart,inEnd,n.data);
		n.left = constructTree(inorder, preorder, preStart, index-1);
		n.right = constructTree(inorder, preorder, index+1, inEnd);
		
		return n;
		
	}
	public static int searchInOrderChar(Integer[] inorder,int preStart, int inEnd,int s){
		int index = -1;
		for(int i =preStart;i<=inEnd ;i++){
			try{
				if(s==inorder[i]){
					index = i;
					break;
				}
			}catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
			
		}
		return index;
	}

}
