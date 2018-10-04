package problem.string;

public class IsAnagram {

	public static boolean isAnagram(String word, String anagram){
		
		if(word.length()!=anagram.length()){
			return false;
		}
		
		
		for(int i = 0 ; i < word.length() ;i++){
			char c = word.charAt(i);
			int index = anagram.indexOf(c);
			if(index != -1){
				anagram = anagram.substring(0, index) + anagram.substring(index+1);
			}else{
				return false;
			}
					
		}
		return anagram.isEmpty();
	}
	
	public static void main(String args[]) {
			
		System.out.println(isAnagram("hello", "ohell"));
	}
}
