package practice;

import java.util.Stack;
/*
 * 
    Create an empty stack.
    Start from the first bar, and do the following for every bar hist[i] where ‘i‘ varies from 0 to n-1
        If the stack is empty or hist[i] is higher than the bar at top of the stack, then push ‘i‘ to stack. 
        If this bar is smaller than the top of the stack, then keep removing the top of the stack while the top of the stack is greater. 
        Let the removed bar be hist[tp]. Calculate the area of the rectangle with hist[tp] as the smallest bar. 
        For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i‘ (current index).
    If the stack is not empty, then one by one remove all bars from the stack and do step (2.2 and 2.3) for every removed bar

 */
public class MaxAreaOfRectangle {
	
	public static void main(String args[]){
		int height[] = {5,4,3,2,4,8,7,1,5,20};
		int i =0 ;
		int maxArea = -1;
		Stack<Integer> indexStack = new Stack<Integer>();
		int width ;
		int pop;
		while(i < height.length){
		
			if(indexStack.isEmpty() || height[indexStack.peek()]<= height[i]){
				indexStack.push(i++); // push until current bar is greater than stack top
			} else {
				// pop until current bar is less than stack top  /  stack is empty
				pop = indexStack.pop();
				width = indexStack.isEmpty() ? i :i -1 - indexStack.peek();
				if(maxArea < height[pop] * width){
					maxArea = height[pop] * width;
				}
						
			}
		}
		while(!indexStack.isEmpty()){
			pop = indexStack.pop();
			width = indexStack.isEmpty() ? i :i -1 - indexStack.peek();
			if(maxArea < height[pop] * width){
				maxArea = height[pop] * width;
			}
		}
		System.out.println("MaxArea=" + maxArea);
	}

}
