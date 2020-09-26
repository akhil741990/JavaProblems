package problem.array;

import java.util.ArrayList;
import java.util.List;

public class MaxValueAfterMRangeOps {

	
	static class Range{
		int start;
		int end;
		int value;
		public Range(int start, int end, int value){
			this.start =start;
			this.end = end;
			this.value = value;
		}
	}
	public static int getMax(List<Range> list, int n){
		int max = 0;
		int array[] = new int[n+1];
		for(int i =0 ; i < list.size() ; i++){
			int lowerBound = list.get(i).start;
			int upperBound = list.get(i).end;
			int value = list.get(i).value;
			array[lowerBound] = array[lowerBound] + value;
			if(upperBound+1<=n){
				array[upperBound+1] = array[upperBound+1] - value;
			}
			 
		}
		int sum = 0;
		int index = -1;
		for(int i = 1; i <=n;i++ ){
			sum = sum + array[i];
			if(max <  sum){
				max = sum;
				index =  i;
			}
		}
		System.out.println("Index="+index);
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //start index is 1
		List<Range> list = new ArrayList<Range>();
		list.add(new Range(1,3,2));
		list.add(new Range(2,5,4));
		list.add(new Range(3,6,1));
		list.add(new Range(8,9,50));
//		list.add(new Range(1,2,100));
//		list.add(new Range(2,5,100));
//		list.add(new Range(3,4,100));
		int max = getMax(list, 10);
		System.out.println("Max = " + max);
	}

}
