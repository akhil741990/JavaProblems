package practice;

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr[] = {0,0,0,0,0,0,0,1,1};
		
		int fisrtBadVersion = find(arr);
		
		System.out.println("FirstBadVersion.main() : " + fisrtBadVersion);
		
		int result = find1(arr);
		System.out.println("FirstBadVersion.main() : " + result);
	}
	
	public static int find(int arr[]){
		
		int result = 0;
		int first = 0;
		int mid;
		int last = arr.length -1;
		
		while(first <= last){
			
			
			mid = (first + last)/2;
			
			if(arr[mid] == 1){
				last = mid -1;
			}else{
				first = mid +1;
			}
			
			if(arr[mid] == 1 && arr[mid-1] == 0){
				result = mid ;
				break;
			}else if (arr[mid] ==0 && arr[mid +1] ==1){
				result = mid+1;
				break;
			}
		}	
		return result;
	
    }
	
	public static int find1(int arr[]){
		int result =0;
		
		int first,mid,last;
		first =0 ;
		last = arr.length -1;
		
		while(first <= last){
			mid = (first + last)/2;
			
			if(arr[mid] ==  1){
				
				if(arr[mid -1] == 0){
					result = mid;
					break;
				}else {
					last = mid -1;
				}
				
			}else {
				first = mid + 1;
			}
		}
		
		return result;
	}
}
