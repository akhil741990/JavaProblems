package practice;

public class MaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int stockPriceStream[] = {5,6,8,10,4,3,2,4,8,7,1,5,10};
		int currentPrice = stockPriceStream[0];
		int previousPrice = stockPriceStream[0];
		int dipPrice;
		int maxProfit = -1;
		int buyIndex = 0;
		
		for(int i =1; i< stockPriceStream.length;i++){
			currentPrice = stockPriceStream[i];
			if(maxProfit < (currentPrice-stockPriceStream[buyIndex])){
				maxProfit = currentPrice - stockPriceStream[buyIndex];
			}
			if(stockPriceStream[i] < stockPriceStream[buyIndex]) {
				System.out.println("Bought the stock at index " + buyIndex);
				System.out.println("Selling the stock at index " + (i -1));
				System.out.println("MaxProfit till now = "+ maxProfit);
				
				buyIndex = i;
			}
			previousPrice = currentPrice;
		}
		System.out.println("MaxProfit="+ maxProfit);
	}

}
