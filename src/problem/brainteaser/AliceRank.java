package problem.brainteaser;

import java.util.Arrays;
/*
 
 Alice is playing an arcade game and wants to climb to the top of the leaderboard and wants to track her ranking. The game uses Dense Ranking, so its leaderboard works like this:

The player with the highest score is ranked number  on the leaderboard.
Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
For example, the four players on the leaderboard have high scores of , , , and . Those players will have ranks , , , and , respectively. If Alice's scores are ,  and , her rankings after each game are ,  and .

Function Description

Complete the climbingLeaderboard function in the editor below. It should return an integer array where each element  represents Alice's rank after the  game.

climbingLeaderboard has the following parameter(s):

scores: an array of integers that represent leaderboard scores
alice: an array of integers that represent Alice's scores
Input Format

The first line contains an integer , the number of players on the leaderboard.
The next line contains  space-separated integers , the leaderboard scores in decreasing order.
The next line contains an integer, , denoting the number games Alice plays.
The last line contains  space-separated integers , the game scores.
 */

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
