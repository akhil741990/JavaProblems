package problem.linkedlist;


class SinglelyLinkedList{
	Node head;
	
	class Node{
		String data;
		Node next;
		
		public Node() {
			// TODO Auto-generated constructor stub
		}
		
		public Node(String data) {
			this.data = data;
		}
		
	}
	
	public void addNode(String data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = new Node(data);
	}
	
	public void printList(){
		if(head == null){
			System.out.println("Linked list is empty");
			return;
		}
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.data + "->");
			temp = temp.next;
		}
	}
	
	public String findNthNodeFromEnd(int n){
		String result = "";
		Node slow,fast;
		slow = fast = head;
		int length = 0;
		while(fast != null){
			length++;
			if(length > n){
				slow = slow.next;
			}
			fast = fast.next;
		}
		result = slow.data;
		return result; 
	}
}
