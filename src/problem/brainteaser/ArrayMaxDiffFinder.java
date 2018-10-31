package problem.brainteaser;

public class ArrayMaxDiffFinder {
	public static void main(String args[]){
		int a[] = {26,8,7,6,4};
		System.out.println(maxDiffFinder(a));
	}
	
	public static int maxDiffFinder(int a[]){
		int maxDiff = a[1] - a[0];
		int min = a[0];
		for (int i=1;i<a.length;i++){
			if((a[i] - min) > maxDiff){
				maxDiff = a[i] - min;
			}
			if(a[i]<min){
				min = a[i];
			}
		}
		return maxDiff; 
	}
	
	public static void test1(int arr[]){
		
	}
}
