package problem.tree;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class VerticalOrderTraversal {

	
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
	
	public  static void traverseVertically(Node root, int hd, TreeMap<Integer, Vector<Integer>> map){

		if(root == null){
			return;
		}
		Vector<Integer> nodes = map.get(hd);
		
		if(nodes == null){
			nodes = new Vector<Integer>();
			map.put(hd, nodes);
		}
		nodes.add(root.data);
		
		traverseVertically(root.left, hd -1, map);
		traverseVertically(root.right, hd +1 , map);
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
		TreeMap<Integer, Vector<Integer>> map = new TreeMap<Integer, Vector<Integer>>();
		traverseVertically(root, 0, map);
		
		for(Map.Entry<Integer, Vector<Integer>> entry: map.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

}
