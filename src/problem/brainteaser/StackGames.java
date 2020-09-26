package problem.brainteaser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
 * Alexa has two stacks of non-negative integers, stack  and stack  where index  denotes the top of the stack. Alexa challenges Nick to play the following game:

In each move, Nick can remove one integer from the top of either stack  or stack .
Nick keeps a running sum of the integers he removes from the two stacks.
Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer  given at the beginning of the game.
Nick's final score is the total number of integers he has removed from the two stacks.
 */



public class StackGames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//
//        int g = Integer.parseInt(scanner.nextLine().trim());
//
//        for (int gItr = 0; gItr < g; gItr++) {
//            String[] nmx = scanner.nextLine().split(" ");
//
//            int n = Integer.parseInt(nmx[0].trim());
//
//            int m = Integer.parseInt(nmx[1].trim());
//
//            int x = Integer.parseInt(nmx[2].trim());
//
//            int[] a = new int[n];
//
//            String[] aItems = scanner.nextLine().split(" ");
//
//            for (int aItr = 0; aItr < n; aItr++) {
//                int aItem = Integer.parseInt(aItems[aItr].trim());
//                a[aItr] = aItem;
//            }
//
//            int[] b = new int[m];
//
//            String[] bItems = scanner.nextLine().split(" ");
//
//            for (int bItr = 0; bItr < m; bItr++) {
//                int bItem = Integer.parseInt(bItems[bItr].trim());
//                b[bItr] = bItem;
//            }
//
            
		   int []a = {19,9,8,13,1,7,18,0,19,19,10,5,15,19,0,0,16,12,5,10};
		   int []b={11,17,1,18,14,12,9,18,14,3,4,13,4,12,6,5,12,16,5,11,16,8,16,3,7,8,3,3,0,1,13,4,10,7,14};
		   int result = twoSackGameOptimized(67, a, b);

           System.out.println(result);
        }   


	
	static int twoStacks(int x, int[] a, int[] b) {
        /*
         * Write your code here.
         */
         int count = 0;
         int sum = 0;

         int i=0,j=0;
         while(i<a.length && j < b.length){
             if(sum >= x){
                 break;
             }
             if(a[i] < b[j]){

                 if((sum + a[i]) <=x ){
                     sum = sum + a[i];
                    count++;
                    i++;
                 }else{
                     break;
                 }
                 
             }else{

                 if((sum + b[j]) <= x){
                     sum = sum + b[j];
                    count++;
                    j++;
                 }else{
                     break;
                 }
                 
             }
             
         }
         while(i<a.length){
             if((sum + a[i]) <= x){
                 sum = sum + a[i];
                i++;
                count++;
             }else{
                 break;
             }
             
         }

         while(j<b.length){
             if((sum + b[j]) <= x){
                 sum = sum + b[j];
                 j++;
                count++;
             }else{
                 break;
             }
             
         }   
         return count;

    }

	private static int getCount(int a[], int index, int threshold){
		int count = 0;
		int sum = 0;
		for(int i = index; i< a.length;i++){
			if((sum + a[i]) <= threshold){
				count++;
				sum = sum + a[i];
				System.out.print(a[i]+",");
			}else{
				break;
			}
		}
		System.out.println("");
		return count;
	}
	
	private static int twoStackCount(int x, int[] a, int[] b){
		int threshold = x;
		int count  = 0;
		int sum =0,i=0,j=0;
		while(i<a.length && j < b.length){
            
			System.out.println("Threshold=>" + threshold);
			System.out.print("A=>");
            int countA = getCount(a, i, threshold);
            System.out.print("B=>");
            int countB = getCount(b, j, threshold);
			if(countA > countB){

                if((sum + a[i]) <=x ){
                    sum = sum + a[i];
                   count++;
                   i++;
                   threshold = threshold - a[i];
                }else{
                    break;
                }
                
            }else{

                if((sum + b[j]) <= x){
                    sum = sum + b[j];
                   count++;
                   j++;
                   threshold = threshold - b[j];
                }else{
                    break;
                }
                
            }
            
        }
        while(i<a.length){
            if((sum + a[i]) <= x){
                sum = sum + a[i];
               i++;
               count++;
            }else{
                break;
            }
            
        }

        while(j<b.length){
            if((sum + b[j]) <= x){
                sum = sum + b[j];
                j++;
               count++;
            }else{
                break;
            }
            
        }
		return count;
	}
	
	
	
	private static int twoSackGameOptimized(int x, int[] a, int[] b){
		int count = 0;
		
		int countA =0;
		int countB =0;
		int sumA=0;
		int sumB=0;
		while(countA<a.length && sumA+a[countA]<=x){
			sumA = sumA + a[countA++];
		}
		
		while(countB<b.length && sumB+b[countB] <= (x-sumA)){
			sumB = sumB + b[countB++];
		}
		count  = countA + countB;
		
		
		while(countA > 0){
			sumA = sumA - a[--countA];
			while(countB < b.length && sumA + sumB + b[countB]<= x){
				sumB = sumB + b[countB++];
			}
			count = Math.max(count, countA + countB);
		}
		
		return count;
	}
	
}
