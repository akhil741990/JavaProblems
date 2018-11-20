package problem.brainteaser;

import java.util.Arrays;

public class CoinDynamicPrograming {

	
	
	public static int minCon(int [] coins, int value){
		int table[] = new int[value + 1];
		Arrays.fill(table, Integer.MAX_VALUE);
		table[0]  = 0;
		
		for (int i = 1 ; i <= value;i++ ){
			for(int j = 0 ; j < coins.length;j++){
				
				if(coins[j] <= i){
					int res = table[i - coins[j]];
					
					if(res!=Integer.MAX_VALUE && res + 1 < table[i]){
						table[i] = res + 1;
					}
				}
			}
		}
		return table[value];
	}
	
	
	public static void main(String args[]){
		 int coins[] =  {9, 6, 5, 1}; 
		 int result = minCon(coins, 10);
		 System.out.println("Number of coins:"+result);
	}
}
