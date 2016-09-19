package problem;
// This program calculates the occurrence(continuous or discontinuous) 
//of a sequence in a string

public class SequenceOccuranceCount {
	public static void main(String args[]){
		String str = "Geeks for Geeks";
		String sequence = "Gks";
		char str1[] = str.toCharArray();
		char sequence1[] = sequence.toCharArray();
		
		int n = countOccurrence(str1,sequence1,str1.length,sequence1.length);
		System.out.println("Count ="+n);
	}
	
	
	private static int  countOccurrence(char str1[],char sequence1[], int strLen, int seqLen){
		if((strLen == 0 && seqLen ==0)|| seqLen==0){
			 return 1;
		}
		if(strLen == 0){
			return 0;
		}
		if(str1[strLen-1] == sequence1[seqLen-1]){
			return countOccurrence(str1,sequence1,strLen-1,seqLen-1) + countOccurrence(str1,sequence1,strLen-1,seqLen);  
		}else{
			return countOccurrence(str1,sequence1,strLen-1,seqLen);
		}
			
	}
}
