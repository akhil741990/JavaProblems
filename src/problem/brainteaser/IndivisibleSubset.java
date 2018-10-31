package problem.brainteaser;

import java.util.Arrays;

public class IndivisibleSubset {
	
	/*
	 * We can solve this problem by computing modulo of array numbers with K. if sum of two numbers is divisible by K, then if one of them gives remainder i, other will give remainder (K � i). First we store frequencies of numbers giving specific remainder in a frequency array of size K. Then we loop for all remainders i and include max(f[i], f[K � i]). Why? a subset with no pair sum divisible by K must include either elements with remainder f[i] or with remainder f[K � i]. Since we want to maximize the size of subset, we pick maximum of two sizes.
In below code array numbers with remainder 0 and remainder K/2 are handled separately. If we include more than 2 numbers with remainder 0 then their sum will be divisible by K, so we have taken at max 1 number in our consideration, same is the case with array numbers giving remainder K/2.
	 */
	public static void main(String args[]){
		
		int arr[] = {3, 17, 12, 9, 11, 15};
		int k = 5;  //Divisor
		
		int modulo [] = new int[k];
		Arrays.fill(modulo, 0);
		
		for( int i =0; i < arr.length;i++  ){
			int mod = arr[i] % k;
			modulo[mod] = modulo[mod] +1;
		}
		
		if(k%2 == 0){
			modulo[k%2] = Math.min(modulo[k%2], 1);
		}
		int maxSetSize = Math.max(modulo[0], 1);
		
		for(int i = 1;i <= k/2;i++){
			maxSetSize += Math.max(modulo[i], modulo[k-1]);
		}
		
		System.out.println("Max size of indivisble subset :"+maxSetSize);
	}
}
