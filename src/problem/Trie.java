package problem;

public class Trie {
	static final int ALPHABET_SIZE = 26;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String keys[] = {"the", "a", "there", "answer", "any", 
                "by", "bye", "their"}; 

		String output[] = {"Not present in trie", "Present in trie"}; 
		
		
		root = new TrieNode(); 

		// Construct trie 
		int i; 
		for (i = 0; i < keys.length ; i++) 
			addNode(keys[i]); 
		
		String key = "ther";
		System.out.println("Searching=>" + key + ":" + search(key));
	}
	
	static class TrieNode{
		TrieNode [] children = new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;
		public TrieNode() {
			 isEndOfWord = false; 
	            for (int i = 0; i < ALPHABET_SIZE; i++) 
	                children[i] = null; 
		}
	}
	
	static TrieNode root;
	
	public static void addNode(String key){
		int index = 0;
		TrieNode traverser = root;
		for(int level =0 ; level < key.length();level++){
			index = key.charAt(level) - 'a';
			if(traverser.children[index] == null){
				traverser.children[index] = new TrieNode();
			}
			traverser = traverser.children[index];
			
		}
		//Marking end of word
		traverser.isEndOfWord = true;
	}
	
	public static boolean search(String key){
		int index = 0;
		TrieNode traverser = root;
		for(int level =0 ; level < key.length();level++){
			index = key.charAt(level) - 'a';
			if(traverser.children[index] == null){
				return false;
			}
			traverser = traverser.children[index];
			
		}
		return (traverser!=null && traverser.isEndOfWord);
	}
	
}
