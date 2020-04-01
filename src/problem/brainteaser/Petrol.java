package problem.brainteaser;
/*
 * Suppose there is a circle. There are  petrol pumps on that circle. Petrol pumps are numbered  to  
 * (both inclusive). You have two pieces of information corresponding to each of the
 *  petrol pump: (1) the amount of petrol that particular petrol pump will give,
 *   and (2) the distance from that petrol pump to the next petrol pump.
Initially, you have a tank of infinite capacity carrying no petrol.
 You can start the tour at any of the petrol pumps.
  Calculate the first point from where the truck will be able to complete the circle.
   Consider that the truck will stop at each of the petrol pumps.
    The truck will move one kilometer for each litre of the petrol.
 * 
 * 
 */
public class Petrol 
{ 
	// A petrol pump has petrol and distance to next petrol pump 

	

	public static void main(String[] args) 
	{ 
		
		
		int[][] arr1 = {{6, 4}, 
				{3, 6}, 
				{7, 3}}; 

		int start = truckTour(arr1); 
		
		System.out.println(start == -1 ? "No Solution" : "Start = " + start); 

	} 

	 static int truckTour(int[][] truckTour) {
	        /*
	         * Write your code here.
	         */
	        int n = truckTour.length;
	        int start =0 ;
	        int end   =1;
	        int  curPetrol = truckTour[start][0] - truckTour[start][1];
	        while(curPetrol < 0 || start !=end){

	            while(curPetrol < 0 && start !=end){
	                curPetrol = curPetrol - (truckTour[start][0] - truckTour[start][1]);
	                start = (start +1 ) % n;
	                if(start == 0){
	                    return -1;
	                }
	            }
	            curPetrol = curPetrol + truckTour[end][0] - truckTour[end][1];
	            end  = (end + 1) % n;
	        }
	        return start;
	    }
} 

