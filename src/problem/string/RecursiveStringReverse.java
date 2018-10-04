package problem.string;

public class RecursiveStringReverse {
	public static void main(String args[]){
		String str = "necessary";
		System.out.println(str);
		System.out.println(reverse(str, str.length()));
	}
	public static String reverse(String str, int length){
		if(length ==0){
			return ""; 
		}else{
			return str.charAt(length-1) + reverse(str, length -1); 
		}
	}
}
