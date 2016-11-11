package robot;

public class Robot {
	private int  x,y;
	private int l,r,f,b;
	public void setIintialPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setUnitMovement(int unitMovement){
		this.l= this.r =this.f =this.b = unitMovement;
	}
	public void setMovementUnits(int l, int r, int f, int b){
		this.l = l;
		this.r = r;
		this.f = f;
		this.b = b;
	}
	
	public void start(String input){
		for(char c : input.toCharArray()){
			switch(c){
				case 'L':
					this. x = this.x - 1;
					break;
				case 'R':
					this. x = this.x + 1;
					break;
				case 'F':
					this. y = this.y + 1;
					break;
				case 'B':
					this. y = this.y - 1;
					break;	
			}
		}
		
		System.out.println("Final Co-ordinates:("+this.x + ","+this.y +")");
	}
	
	public static void main(String args[]){
		Robot r = new Robot();
		r.setIintialPosition(0, 0);
		r.setUnitMovement(1);
		
		r.start("RRRRFFFFFLLLBBBLLLL");
		
	}

}
