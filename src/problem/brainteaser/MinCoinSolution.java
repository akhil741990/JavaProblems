package problem.brainteaser;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MinCoinSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Integer arr[] = {1,2,5,10};
			int amount;
			for(int i =0; i <10; i++){
				amount = getRandomAmount();
				System.out.println("Amount="+amount);
				printMinimumCoins(arr, amount);
				System.out.println("=============X==============");
			}
			
	}

	private static void printMinimumCoins(Integer[] arr, int amount) {
		List<Integer> coins = Arrays.asList(arr);
		Collections.sort(coins, Collections.reverseOrder());		
		int coinIndex = 0;
		int totalCoins = 0;
		int quotient =0;
		while(amount > 0 && coinIndex < coins.size()){
		
			if(amount >= coins.get(coinIndex)){
				quotient = amount / coins.get(coinIndex);
				amount = amount % coins.get(coinIndex);
				System.out.println(quotient+"coins of " +  coins.get(coinIndex));
				totalCoins = totalCoins + quotient;
				coinIndex++;
			} else {
				coinIndex++;
			}
		}
		System.out.println("totalCoins : " + totalCoins);
	}
	
	private static  int getRandomAmount() {
		Random r = new Random();
		int low = 0;
		int high = 100;
		int result = r.nextInt(high-low) + low;
		return result;
	}

}
