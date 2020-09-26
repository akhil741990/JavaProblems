package problem.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
/*
 * There are a number of plants in a garden. Each of these plants has been treated with some amount of pesticide. After each day, if any plant has more pesticide than the plant on its left, being weaker than the left one, it dies.

You are given the initial values of the pesticide in each of the plants. Print the number of days after which no plant dies, i.e. the time after which there are no plants with more pesticide content than the plant to their left.

For example, pesticide levels . Using a -indexed array, day  plants  and  die leaving . On day , plant  of the current array dies leaving . As there is no plant with a higher concentration of pesticide than the one to its left, plants stop dying after day .

Function Description 
Complete the function poisonousPlants in the editor below. It must return an integer representing the number of days until plants no longer die from pesticide.

poisonousPlants has the following parameter(s):

p: an array of integers representing pesticide levels in each plant
Input Format

The first line contains an integer , the size of the array . 
The next line contains  space-separated integers .

Constraints

 

Output Format

Output an integer equal to the number of days after which no plants die.

Sample Input

7
6 5 8 4 7 10 9
Sample Output

2
Explanation

Initially all plants are alive.

Plants = {(6,1), (5,2), (8,3), (4,4), (7,5), (10,6), (9,7)}

Plants[k] = (i,j) => jth plant has pesticide amount = i.

After the 1st day, 4 plants remain as plants 3, 5, and 6 die.

Plants = {(6,1), (5,2), (4,4), (9,7)}

After the 2nd day, 3 plants survive as plant 7 dies.

Plants = {(6,1), (5,2), (4,4)}

After the 2nd day the plants stop dying.
 */

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
				System.out.println("won't die :" + pest[i]);
			}else if(popedElement == -1){
				span[i] = 1; // die in first iteration
				System.out.println("die in first iteration :" + pest[i]);
			}else {
				span[i] = maxSpan + 1;
				System.out.println("die in next iteration :" + pest[i]);

				
			}
			stack.push(i);
			//printArray(span);
		}
		return Collections.max(Arrays.asList(span)); 
    
	}
	
	static void printArray(Integer arr[]) 
	{ 
		System.out.println(Arrays.toString(arr)); 
	}

}
