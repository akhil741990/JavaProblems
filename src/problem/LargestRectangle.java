package problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LargestRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []h = {1,2,3,1,1};
		int area = largestRectangleLatest(h);
		System.out.println("area="+area);
	}
	
	
	static int largestRectangleLatest(int[] h){
		int area = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while( i < h.length ){
			if(stack.isEmpty() || h[stack.peek()]<=h[i]){
				stack.push(i++);
			}else{
				int top = stack.peek();
				stack.pop();
				int tempArea = h[top] * (stack.isEmpty() ? i: (i-stack.peek() -1));
				if(area <  tempArea){
					area = tempArea;
				}
			}
		}
		while(!stack.isEmpty()){
			int top = stack.peek();
			stack.pop();
			int tempArea = h[top] * (stack.isEmpty() ? i: (i-stack.peek() -1));
			if(area <  tempArea){
				area = tempArea;
			}
		}
		return area;
	}
	
	static int largestRectangleNewest(int[] h) {
		int area = 0;
		int hNew[] = new int[h.length];
		for(int i=0;i<h.length;i++){
			hNew[i]=h[i];
		}
		Arrays.sort(hNew);
		Map<Integer, Integer> table = new HashMap<Integer, Integer>();
		for(int i=0;i<h.length;i++){
			if(!table.containsKey(hNew[i])){
				int consecCountLocal=0;
				int  consecCountLargest=0;
				int lastIndex=-2;
				for(int j=0;j<h.length;j++){
					if(h[j]>=hNew[i]){
						if((j - lastIndex)==1){
							consecCountLocal++;
						}else{
							if(consecCountLocal>= consecCountLargest){
								consecCountLargest = consecCountLocal;
								consecCountLocal =0;
							}
						}
						lastIndex = j;
					}
				}
				if(consecCountLocal >= consecCountLargest){
					consecCountLargest = consecCountLocal;
				}
				if(area < (consecCountLargest+1)*hNew[i]){
					area = (consecCountLargest+1)*hNew[i];
				}
				table.put(hNew[i], consecCountLargest);
			}
		}
		
		for(int i : table.keySet()){
			System.out.println(i+"="+table.get(i));
			if(i*(table.get(i)+1)>=area){
				area = i*(table.get(i)+1);
			}
		}
		return area;
	}
	
	
	static int largestRectangle(int[] h) {
		 
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
