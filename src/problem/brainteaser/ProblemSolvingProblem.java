package problem.brainteaser;

public class ProblemSolvingProblem {
	/*
	 * There are N problems numbered 1..N which you need to complete. You've arranged the problems in increasing difficulty order, and the ith problem has estimated difficulty level i. You have also assigned a rating vi to each problem. Problems with similar vi values are similar in nature. On each day, you will choose a subset of the problems and solve them. You've decided that each subsequent problem solved on the day should be tougher than the previous problem you solved on that day. Also, to make it less boring, consecutive problems you solve should differ in their vi rating by at least K. What is the least number of days in which you can solve all problems?

Input Format

The first line contains the number of test cases T. T test cases follow. Each case contains an integer N and K on the first line, followed by integers v1,...,vn on the second line.

Constraints

1 <= T <= 100 
1 <= N <= 300 
1 <= vi <= 1000 
1 <= K <= 1000

Output Format

Output T lines, one for each test case, containing the minimum number of days in which all problems can be solved.

Sample Input

2  
3 2  
5 4 7  
5 1  
5 3 4 5 6
Sample Output

2  
1
Explanation

For the first example, you can solve the problems with rating 5 and 7 on the first day and the problem with rating 4 on the next day. Note that the problems with rating 5 and 4 cannot be completed consecutively because the ratings should differ by at least K (which is 2). Also, the problems cannot be completed in order 5,7,4 in one day because the problems solved on a day should be in increasing difficulty level.

For the second example, all problems can be solved on the same day.git
	 */


	 public static void main(String args[]){
		 int arr[] = {5,3,4,5,6};
		 System.out.println("Start");
		 System.out.println(problemSolving(1, arr));
		 System.out.println("End");
	 }
	 static int problemSolving(int k, int[] v) {
	        /*
	         * Write your code here.
	         */
	         int visited [] = new int[v.length];
	         int days = 0;
	         int prob1Index = 0;
	         int toBeSolved = v.length;
	         int diffFound = 0;
	         int probFoundIndex = -1;
	         while(toBeSolved > 0){
	             for (int vi = 0; vi < v.length; vi++) {
	            	probFoundIndex = -1;
	            	diffFound = 0;
	                if (visited[vi] != 1) {
	                    prob1Index  = vi;
	                    probFoundIndex = vi;
	                    for(int j = vi+1;j< v.length;j++){
	                    	
	                    	if(visited[j]!=1){
	                    		probFoundIndex = j;
	                    		if(Math.abs(v[prob1Index] -v[j]) >=k){
	                    			toBeSolved = toBeSolved -2;
		                            visited[prob1Index] = 1;
		                            visited[j] = 1; 
		                            prob1Index = j;
		                            diffFound = 1;
	                    		}
	                    	}

	                    }
	                    if((probFoundIndex > 0 ) &&  (diffFound == 0)){
	                    	visited[probFoundIndex] = 1;
	                    	toBeSolved--;
	                    }
	                    days++;
	                }
	            }
	            
	         }
	         
	         return days;

	    }
}
