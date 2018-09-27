package problem;

import java.util.HashSet;
import java.util.Set;

public class ArraySumFinder {
	public static void main(String args[]) {
		int arr [] = {1,-1,3,2,0,4,5,1,2};
		Set<Integer> s = new HashSet<>(arr.length);
		int sum = 4;
		int target;
		for(int i : arr) {
			target = 4 - i;
			if(!s.contains(target)) {
				s.add(i);
			}else {
				System.out.println("Sum Pait found ("+i+","+target+")");
			}
		}
	}
}
