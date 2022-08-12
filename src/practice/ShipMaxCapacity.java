package practice;

public class ShipMaxCapacity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {3,2,2,4,1,4};
		int days = 3;
		shipMaxCapacity(arr, days);
	}

	public static void shipMaxCapacity(int arr[], int days){
		
		int sum = 0;
		int max = -1;
		for(int i =0 ; i < arr.length;i++){
			sum += arr[i];  // total weight
			max = Math.max(max, arr[i]);  // the item with max weight ie least capacity of ship
		}
		int mid ;
		int result = -1;
		while(max <= sum){
			mid = max + (sum - max)/2;
			if(isShippable(arr, mid, days)){
				result = mid;
				sum = mid - 1;
			}else{
				max = mid + 1;
			}
		}
		System.out.println("maxCap =" + result);
	}
	
	public static  boolean isShippable(int arr[], int maxCap, int days){
		boolean result = true;
		
		int sum = 0;
		int shippingDays =1;
		for(int i =0; i < arr.length;i++){
			sum = sum + arr[i];
			if(sum > maxCap){ // add a day and reset sum 
				shippingDays++;
				sum = arr[i];
			}
			
			if(shippingDays > days){
				result = false;
				break;
			}
		}
		return result;
	}
}
