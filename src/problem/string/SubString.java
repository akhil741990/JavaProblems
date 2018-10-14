package problem.string;

public class SubString {

	public static void main(String args[]){
		String s = "abcdef";
		printAllSubString(s);
	}
	
	public static void printAllSubString(String s){
		int len = s.length();
		
		for(int i = 1; i <= len;i++ ){   // size of sub string
			
			for(int j=0; j<len; j++){
				if((i+j) <= len ){
					System.out.println(s.substring(j,(j+i)));
				}
				
			}
		}
	}
}
