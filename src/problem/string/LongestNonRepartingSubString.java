package problem.string;

import java.util.Arrays;

public class LongestNonRepartingSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "GeeksForGeeks";
		getLongestNonRepeatingSubString(str);
		getLongestNonRepeatingSubStringOptimized(str);
	}
    public static String getLongestNonRepeatingSubString(String str){
    	String subStr = "";
    	int maxLength = -1;
    	for(int i = 0; i<  str.length();i++){
    		int arr[] =new int[256];
    		int count =0;
            int endIndex = i;    		
    		for(int j = i; j < str.length();j++){
    			
    			if(arr[str.charAt(j)] == 1){
    				endIndex = j;
    				break;
    			}else{
    				arr[str.charAt(j)] =1;
    				count++;
    			}
    		}
    		if(count > maxLength){
    			maxLength = count;
    			subStr = str.substring(i, endIndex);
    		}
    	}
    	System.out.println("Length : " + maxLength);
    	System.out.println("SubStr:" + subStr);
    	return subStr;
    }
    public static void getLongestNonRepeatingSubStringOptimized(String str){
    	int lastIndex [] = new int[256];
    	Arrays.fill(lastIndex, -1);
    	int i =0;
    	int maxLength = 0;
    	for(int j = 0;j< str.length();j++){
    		i = Math.max(i, lastIndex[str.charAt(j)] +1);
    		
    		maxLength = Math.max(maxLength, j-i + 1);
    		lastIndex[str.charAt(j)] = j;
    	}
    	System.out.println("length of subString:" + maxLength);
    }
}
