package problem.stack;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class StackUsing2Qs {

	Queue<Integer>q1;
	Queue<Integer>q2;
	public StackUsing2Qs() {
		q1 = new LinkedBlockingQueue<Integer>();
		q2 = new LinkedBlockingQueue<Integer>();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsing2Qs stack = new StackUsing2Qs();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		stack.push(4);
		
		stack.print();
		
	}
	
	public Integer pop(){
		
		Integer i = null;
		while(!q1.isEmpty()){
			i = q1.poll();
			if(!q1.isEmpty()){
				q2.add(i);
			}
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		System.out.println("Popped:"+i);
		return i;
	}

	public void push(Integer i){
		System.out.println("Pushed:"+i);
		q1.add(i);
	}
	
	public void print() {
		while(!q1.isEmpty()){
			Integer i = pop();
			//System.out.println(i);
		}
	}
}
