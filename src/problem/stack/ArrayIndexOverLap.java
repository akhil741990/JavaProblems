package problem.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class ArrayIndexOverLap {
	
	static class Range{
		int start;
		int end;
		public Range(int start, int end){
			this.start =start;
			this.end = end;
		}
	}
	
	public static void printMergedRange(List<Range> list){
		Collections.sort(list, new Comparator<Range>() {

			@Override
			public int compare(Range o1, Range o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});
		
		Stack<Range> stack = new Stack<Range>();
		stack.push(list.get(0));
		for(int i = 1; i < list.size() ;i ++){
			Range top = stack.peek();
			if(top.end < list.get(i).start){
				stack.push(list.get(i));
			}else if(top.end < list.get(i).end){
				top.end = list.get(i).end;
				stack.pop();
				stack.push(top);
			}
		}
		while(!stack.isEmpty()){
			Range top = stack.pop();
			System.out.println(top.start+"---->"+top.end);
		}
	}
	public static void main(String args[]){
		List<Range> list = new ArrayList<ArrayIndexOverLap.Range>();
		list.add(new Range(1,3));
		list.add(new Range(2,5));
		list.add(new Range(6,8));
		printMergedRange(list);
	}

}
