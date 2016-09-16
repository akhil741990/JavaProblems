package problem;

public class PrintAllSubSets {
	public static void main(String args[]){
		char set[] ={'a','b','c','d'};
		for(int i=0 ; i < Math.pow(2, set.length); i++){
			System.out.println("{");
			for (int j=0 ; j< set.length ;j++){            
				if ((i & (1<<j)) !=0){                  // print the element for which 
					System.out.print(set[j]+" ,");      // the bit is set
				}
			}
			System.out.println("}");
		}
	}
}
