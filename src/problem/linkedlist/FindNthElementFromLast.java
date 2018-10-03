package problem.linkedlist;

public class FindNthElementFromLast {

	public static void main(String args[]){
		SinglelyLinkedList s = new SinglelyLinkedList();
		s.addNode("1");
		s.addNode("2");
		s.addNode("3");
		s.addNode("4");
		s.addNode("5");
		s.addNode("6");
		s.addNode("7");
		s.printList();
		System.out.println(s.findNthNodeFromEnd(3));
	}
	
	
}
