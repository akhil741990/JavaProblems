package problem.string;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		String s = "The situation is under control he workered hard for it continuously";
		
		int arr[] = new int[256];
		for(int i =0 ;i < 256;i++){
			arr[i] = -1;
		}
		
		for(int i = 0; i < s.length(); i++){
			if(arr[s.charAt(i)] == -1){
				arr[s.charAt(i)] = i;
			}else{
				arr[s.charAt(i)] = -2;
			}
		}

		int minIndex = 256;
		for(int i =0 ;i< 256;i++){
			if(arr[i] > 0){
				minIndex = Math.min(arr[i], minIndex);
			}
		}
		
		System.out.println("First Non Repeating Character :  " + s.charAt(minIndex));
	}

}
