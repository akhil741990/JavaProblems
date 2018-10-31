package problem.brainteaser;

public class ArrayIndexOverLapFinder {

	public static boolean isRange1FullOverLap(int range1[], int range2[]) {
		boolean result = false;
		if((range1[0] < range2[0]) && (range1[1] < range2[1])) {
			result = true;
		}
		return result;
	}
	
	public static boolean isRange2FullOverLap(int range1[], int range2[]) {
		boolean result = false;
		if((range2[0] < range1[0]) && (range2[1] < range1[1])) {
			result = true;
		}
		return result;
	}
	
	
	
	public static void main(String args[]) {
		
	}
}
