package problem.brainteaser;

import java.util.Arrays;

public class AliceRank {
	static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int rank [] = new int[scores.length];
        int rankCount = 1;
        rank[0] = rankCount;
        int aliceRank[] = new int[alice.length];
        int previousScore = scores[0];
        for(int i = 1; i< scores.length;i++){
            if(scores[i] == previousScore){
                rank[i] = rank[i-1];
            }else{
                rank[i] = ++rankCount;
            }
            System.out.println("Rank:"+rank[i]);
            previousScore = scores[i];
        }
        int found = 0;
        for(int j = 0; j<alice.length; j++){
            found = 0;
            for(int k =0; k < rank.length; k++){
                if(alice[j] >= scores[k]){
                    aliceRank[j] = rank[k];
                    found = 1;
                    break;
                }
            }
            if(found == 0){
                aliceRank[j] = rank[rank.length -1] + 1;
            }
        }
        return aliceRank;
    }
	
	public static void main(String args[]){
			
		int arr[] = {100, 100, 50, 40, 40 ,20 ,10};
		int arr1[] = {5, 25, 50, 120};
		int result[] = climbingLeaderboard(arr, arr1);
		System.out.println("Result :"+ Arrays.toString(result));
	}
}
