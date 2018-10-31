package problem.brainteaser;

public class QueenAttacks {

	public static void main(String args[]) {
		int rNum = 1;
		int cNum = 2;
	
		System.out.println("Rowise Attack");
		for(int  i = 1;i<=8;i++) {
			if(i!=rNum)
			 System.out.println("("+rNum+","+i+")");
		}
		
		System.out.println("Columnwise Attack");
		for(int  i = 1;i<=8;i++) {
			if(i!=cNum)
			 System.out.println("("+i+","+cNum+")");
		}
		int i,j;
		
		System.out.println("Diagonal(north-west) Attack");
		//north-west
		i = rNum+1;
		j = cNum-1;
		while(j>=1 && i<=8) {
			System.out.println("("+i+","+j+")");
			i++;
			j--;
		}
		
		System.out.println("Diagonal(south-west) Attack");
		//south-west
		i = rNum-1;
		j = cNum-1;
		while(i>=1 && j>=1) {
			System.out.println("("+i+","+j+")");
			i--;
			j--;
		}
		
		System.out.println("Diagonal(north-east) Attack");
		//north-east
		i = rNum+1;
		j = cNum+1;
		while(i<=8 && j<=8) {
			System.out.println("("+i+","+j+")");
			i++;
			j++;
		}
		System.out.println("Diagonal(south-east) Attack");
		//south-east
		i = rNum-1;
		j = cNum+1;
		while(i>=1 && j<=8) {
			System.out.println("("+i+","+j+")");
			i--;
			j++;
		}
		
	}
}
