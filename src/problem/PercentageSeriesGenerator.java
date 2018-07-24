package problem;

public class PercentageSeriesGenerator {

	
	
	
	public static void main(String args[]) {
		
		int array[] = {1,2,3,4,5};
		int result[] = calculate(array);
		for(int percentage : result) {
			System.out.println(percentage +"%");
		}
	}
	
	public static int[] calculate(int array[]) {
		
		int result[] = new int[array.length -1];
		
		for(int i = 0; i < array.length -1;i++) {
			result[i] = 100 *(array[i+1] - array[i])/array[i]; 
		}
		return result;
		
		
	}
}
