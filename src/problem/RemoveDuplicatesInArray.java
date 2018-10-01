package problem;

import java.util.Arrays;

public class RemoveDuplicatesInArray {
	public static void main(String args[]){
		int arr [] = {8,3,7,4,5,2,3,4,8,0,1,4};
		
		System.out.println("Input :"+ Arrays.toString(arr));
		System.out.println("output:"+ Arrays.toString(removeDuplicateNumbers(arr)));
	}
	
	public static int [] removeDuplicateNumbers(int arr[]){
		int [] result = new int[arr.length];
		Arrays.sort(arr);
		int previous = arr[0];
		result[0] = arr[0];
		int k = 1;
		for(int i =1; i < arr.length ;i++){
			if(previous != arr[i]){
				result[k++] = arr[i];
				previous = arr[i];
			}
			
		}
		return result;
	}
}
