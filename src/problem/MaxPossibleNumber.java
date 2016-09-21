package problem;

/*
 *  There are 2 approaches to solve this problem
 *  1) sort number X,Y such that  XY > YX  then X > Y
 
 * 
 * 2) Sort the numbers in descending order(step 1) then sort the number in descending order(step 2) based on the 
 * first digit.
 * Only insertion sort gives the correct result ( selection and bubble sort changes the natural order of the result of step1) 
 * 
 * 
 */



public class MaxPossibleNumber {
	
	public static void main(String args[]){
		int total = Integer.parseInt(args[0]);
		int []arr = new int[total];
		for(int i = 1;i<=total;i++){
			arr[i-1] = Integer.parseInt(args[i]);
			//System.out.println(arr[i-1]);
		}
		printArray(arr);
		selectionSortDesc(arr);
		printArray(arr);
		insertionSortOnFirstDigit(arr);
		printArray(arr);
		printMaxPossibleNumber(arr);
		/*
		sortDescenting(arr);
		printArray(arr);
		sortDescOnFirstDigit(arr);
		printArray(arr);
		*/
	}

	public static void printArray(int arr[]){
		for(int i = 0; i < arr.length ;i++){
			System.out.println(""+ i +" :"+arr[i]  );
		}
	}
	
	public static void sortDescenting(int arr[]){
		System.out.println("Sorting Descending");
		int temp;
		for(int i = 0; i < arr.length ;i++){
			for( int j = i+1 ; j < arr.length ;j++){
				if (arr[i] < arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;		
				}
			}
		}
	}
	
	public static void sortDescOnFirstDigit(int arr[]){
		System.out.println("Sorting Descending on first Digit");
		int temp, tempi, tempj;
		for(int i = 0; i < arr.length ;i++){
			//printArray(arr);
			for( int j = i+1 ; j < arr.length ;j++){
				//if (i == 1) System.exit(0);
				//printArray(arr);
				tempi = ("" + arr[i]).charAt(0);
				tempj = ("" + arr[j]).charAt(0);
				if (tempi <= tempj){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;		
				}
			}
		}
	}
	
	public static void printMaxPossibleNumber(int arr[]){
		String str ="";
		for(int i = 0; i < arr.length ; i++){
			str = str+arr[i];
		}
		System.out.println("MaxPossibleNumber: "+str);
	}
	
	
	public static void sortDescOnCombination(int arr[]){
		System.out.println("Sorting Descending on first Digit");
		int temp, tempi, tempj;
		for(int i = 0; i < arr.length ;i++){
			for( int j = i+1 ; j < arr.length ;j++){
				tempi = Integer.parseInt(""+arr[i]+arr[j]);
				tempj = Integer.parseInt(""+arr[j]+arr[i]);
				if (tempi < tempj){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;		
				}
			}
		}
	}
	
	
	public static void selectionSortDesc(int arr[]){
		for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] > arr[index])
                    index = j;
      
            int temp = arr[index]; 
            arr[index] = arr[i];
            arr[i] = temp;
        }
	}
	
	public static void selectionSortDescOnFirstDigit(int arr[]){
		
		int tempi,tempj;
		for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
            	tempi = ("" + arr[i]).charAt(0);
				tempj = ("" + arr[j]).charAt(0);
				
                if (tempj > tempi)
                    index = j;
            }
            int temp = arr[index]; 
            arr[index] = arr[i];
            arr[i] = temp;
        }
	}
	
	 public static void insertionSortOnFirstDigit(int array[]) {
	        int n = array.length;
	        for (int j = 1; j < n; j++) {
	            int key = array[j];
	            int keyj = ("" + array[j]).charAt(0);
	            int i = j-1;
	            while ( (i > -1) && ( ("" + array[i]).charAt(0) < keyj) ) {
	                array [i+1] = array [i];
	                i--;
	            }
	            array[i+1] = key;
	           
	        }
	    }
	 
	 
	 public static void insertionSort(int array[]) {
	        int n = array.length;
	        for (int j = 1; j < n; j++) {
	            int key = array[j];
	            int i = j-1;
	            while ( (i > -1) && ( array [i] > key ) ) {
	                array [i+1] = array [i];
	                i--;
	            }
	            array[i+1] = key;
	        }
	    }
}
