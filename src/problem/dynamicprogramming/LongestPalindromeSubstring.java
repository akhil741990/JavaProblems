package problem.dynamicprogramming;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		String s = "abcdefedjghikihgj";
		
		int n = s.length();
		boolean [][]table = new boolean[n][n];
		
		int maxLength = 1;
		
		//All substring of length 1 is palindrome
		for(int i = 0; i < n ;i ++){
			table[i][i]=true;
		}
		
		// checking palindrome of length 2
		int palStartIndex=1 ;
		for(int i = 0; i < n-1; i++){
			if(s.charAt(i) == s.charAt(i+1)){
				table[i][i+1] = true;
				palStartIndex = i;
				maxLength = 2;
			}
		}
		printTable(table);
		// checking plaindrome of length > 2
		
		for(int k = 3 ; k <= n; k++ ){
			//start Index
			for(int i = 0 ; i < n - k + 1; i++ ){
				int j = i + k -1;
				if(table[i+1][j-1] == true && (s.charAt(i)==s.charAt(j))){
					table[i][j] = true;
					palStartIndex = i;
					maxLength = k;
					
					if(k >  maxLength){
						maxLength = k;
						palStartIndex = i;
					}
				}
			}
			
			printTable(table,k);
		}
		System.out.println("LongestPalindromeSubString = " + s.substring(palStartIndex, palStartIndex + maxLength -1));
	}
	
	public static void printTable(boolean table[][]){
		System.out.println("====Printing Table=======");
		for(int i = 0 ; i < table.length ;i++ ){
			for(int j = 0; j < table[i].length;j++ ){
				if(table[i][j]){
					System.err.println(""+i+","+j);
				}
			}
		}
		System.out.println("XXXXXX End of Table XXXXXXXXX");
	}
	
	public static void printTable(boolean table[][], int k){
		System.out.println("====Printing Table=======");
		for(int i = 0 ; i < table.length ;i++ ){
			for(int j = 0; j < table[i].length;j++ ){
				if(table[i][j] && (j-i) == k-1 ){
					System.out.println("PalLength="+k  +" "+i+","+j);
				}
			}
		}
		System.out.println("XXXXXX End of Table XXXXXXXXX");
	}

}
