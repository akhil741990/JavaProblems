package problem;

public class LargestRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []h = {1,2,3,4,5};
		largestRectangle(h);
	}
	
	static long largestRectangle(int[] h) {
		 
        int buildingCount =0;
        for(int i =0 ; i < h.length;i++){
            int count = 0;
            if(i==0){
                for(int j=1; j < h.length;j++){
                    if(h[j]>=h[i]){
                        count++;
                    }else{
                        break;
                    }
                }
            }else if(i == h.length -1){
                for(int j = h.length -2; j >=0;j-- ){
                    if(h[j]>=h[i]){
                        count++;
                    }else{
                        break;
                    }
                }
            }else{
                for(int j =0; j < i;j++){
                    if(h[j]>=h[i]){
                        count++;
                    }else{
                        break;
                    }
                }
                for(int j =i+1; j < h.length;j++){
                    if(h[j]>=h[i]){
                        count++;
                    }else{
                        break;
                    }
                }
            }
            System.out.println("i="+h[i] + "count="+(count+1)*h[i]);
            if(buildingCount < ((count+1) * h[i])){
              buildingCount  = (count+1) * h[i];
            }
        }
        return buildingCount;
    }

}
