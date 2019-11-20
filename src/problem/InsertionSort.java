package problem;


class InsertionSort{

	static int insertionSort(int[] arr) {
        int temp;
        int shiftCount = 0;
        int  j;
        for(int i=1;i<=arr.length - 1;i++){
            temp = arr[i];
            j = i-1;
            while(j>=0 && temp< arr[j]){
                arr[j+1]= arr[j];
                j--;
                shiftCount++;
            }
            arr[j+1] = temp; 
        }
        return shiftCount;
    }
}




