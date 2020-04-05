package problem.stack;

//Java implementation for brute force method to calculate stock span values 

import java.util.Arrays;
import java.util.Stack; 

class StockSpanValue { 
	// method to calculate stock span values 
	static void calculateSpan(int price[], int n, int S[]) 
	{ 
		// Span value of first day is always 1 
		S[0] = 1; 

		// Calculate span value of remaining days by linearly checking 
		// previous days 
		for (int i = 1; i < n; i++) { 
			S[i] = 1; // Initialize span value 

			// Traverse left while the next element on left is smaller 
			// than price[i] 
			for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--) 
				S[i]++; 
			
			printArray(S); 
		} 
	} 

	// A utility function to print elements of array 
	static void printArray(int arr[]) 
	{ 
		System.out.println(Arrays.toString(arr)); 
	} 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		int price[] = { 80, 100, 60, 70, 60, 75,85 }; 
		int n = price.length; 
		int S[] = new int[n]; 
		calcStockSpan(price, n, S); 		
	} 
	public static void calcStockSpan(int price[], int n, int S[]){
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		S[0] =1;
		for(int i =1;i <n; i++ ){
			S[i] =1;
			while(!stack.isEmpty() && price[i]>= price[stack.peek()]){
				stack.pop();
			}
			S[i] = (stack.isEmpty()) ? i + 1 : i - stack.peek();
			stack.push(i);
			printArray(S);
		}
	}
} 


