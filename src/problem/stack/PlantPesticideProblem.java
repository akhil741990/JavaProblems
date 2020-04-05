package problem.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class PlantPesticideProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pest[] = {6,5,8,4,7,10,9 }; 
		int n = pest.length; 
		Integer span[] = new Integer[n]; 
		System.out.println("result= "+calcPlantSurvivalDay(pest, span));
	}
	
	public static int calcPlantSurvivalDay(int pest[], Integer span[]){
		
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0 ; i< pest.length ;i++){
			int maxSpan = 0;
			int popedElement = -1;
			while(!stack.isEmpty() && pest[i] <= pest[stack.peek()]){
				popedElement = stack.pop();
				maxSpan = Math.max(span[popedElement], maxSpan);
			}
			if(stack.isEmpty()){
				span[i] = 0;  // wont die
			}else if(popedElement == -1){
				span[i] = 1; // die in first iteration
			}else {
				span[i] = maxSpan + 1;
			}
			stack.push(i);
			printArray(span);
		}
		return Collections.max(Arrays.asList(span)); 
    
	}
	
	static void printArray(Integer arr[]) 
	{ 
		System.out.println(Arrays.toString(arr)); 
	}

}
