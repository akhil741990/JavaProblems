package problem;

public class ArrayElementDiffFinder {

		public static void main(String args[]){
			int [] arr = {7, 34, 9, 5, 21, 4};
			selectionSortAsc(arr);
			
			int diff = 30;
			int i = 0, j =1;
			
			while(i < arr.length && j < arr.length){
				
				if(i!=j && (arr[j] - arr[i] == diff )){
					System.out.println("Found : a["+j + "]"+"-a["+i+"]"+ "="+ arr[j] + "-"+arr[i] );
					break;
				}
				if(arr[j] - arr[i] > diff){
					i++;
				}else {
					j++;
				}
			}
		}
		
		public static void selectionSortAsc(int arr[]){
			for (int i = 0; i < arr.length - 1; i++)
	        {
	            int index = i;
	            for (int j = i + 1; j < arr.length; j++)
	                if (arr[j] < arr[index])
	                    index = j;
	      
	            int temp = arr[index]; 
	            arr[index] = arr[i];
	            arr[i] = temp;
	        }
		}
}
