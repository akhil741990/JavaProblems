package practice;

import java.util.Arrays;

public class MaxProfitInStockTranscation {

	
	public static void main(String args[]){
		
		int input [] = {7,5,4,4}; 
		int input1 [] = {5,10,7,6,1,4,3,5,8};
		maxDiffFinder(input);
		maxProfit(input);
	}
	
	public static void maxProfit(int arr[]){
		System.out.println("input"+Arrays.toString(arr));
		int buy = arr[0], maxProfit=0;
		int dippingDate=0, sellDate=0;
		int purchaseDate =0;
		for(int i =1; i< arr.length;i++){
			
			if(buy > arr[i]){
				buy = arr[i];
				dippingDate = i;
			}else if ((arr[i] - buy) > maxProfit){
				sellDate = i;
				purchaseDate = dippingDate;
				maxProfit = arr[i] - buy;
			}
		}
		System.out.println("purchaseDate" + purchaseDate);
		System.out.println("sellDate" +  sellDate);
		System.out.println("MaxProfit :"+ maxProfit);
		
		
	}
	
	public static void maxDiffFinder(int arr[]){
		
		System.out.println("Input:" + Arrays.toString(arr));
		
		int maxDiff = arr[1] - arr[0];
		int min = arr[0];
		int dippingDate = 0;
		int sellDate =0 ;
		int purchaseDate=0;
		for (int i =1;i<arr.length;i++){
			if(maxDiff < (arr[i]-min)){
				maxDiff = arr[i]-min;
				sellDate = i;
				purchaseDate = dippingDate;
			}
			if(arr[i]<min){
				min = arr[i];
				dippingDate = i;
			}
		}
		
		if(maxDiff > 0){
			System.out.println("MaxDiff:" +maxDiff);
			System.out.println("purchaseDate" + purchaseDate);
			System.out.println("sellDate" +  sellDate);
		}else{
			System.out.println("MaxPrfit:" +0);
		}
		
	}
}
