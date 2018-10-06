package problem.hackerrank;

public class CarryModMultiply {

	public static void main(String[] args) {
		int res[] = new int[200];
		res[0] = 0;
		res[1] = 2;
		res[2]	= 1;	
		int size = 3;
		String s = "";
		size = mult(size, res, 13);
		for(int i = size -1; i >=0;i--){
			s = s + res[i];
			
		}
		System.out.println("Mult:"+s);
	}

	
	public static int mult(int size, int res[], int num){
		int prod = 0 ;
		int carry = 0;
		for(int i = 0; i < size; i++){
			prod = res[i]*num + carry;
			res[i] = prod % 10;
			carry = prod / 10;
		}
		while(carry!=0){
			res[size] = carry;
			carry = carry /10;
			size++;
		}
		return size;
	}
}
