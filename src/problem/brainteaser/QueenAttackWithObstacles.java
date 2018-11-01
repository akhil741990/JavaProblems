package problem.brainteaser;

import java.util.HashMap;
import java.util.Map;

public class QueenAttackWithObstacles {

	
	 static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

	        int pos = 0;
	        Map<String,Integer> obs = new HashMap<String,Integer>();
	        for(int i = 0 ; i < obstacles.length ;i++){
	            obs.put("("+obstacles[i][0] +","+obstacles[i][0] +")",1);
	        }
	        pos = pos + getAttackPostitions(n, r_q + 1,c_q,1,0,obs);
	        pos = pos + getAttackPostitions(n, r_q - 1,c_q,-1,0,obs);
	        pos = pos + getAttackPostitions(n, r_q,c_q+1,0,1,obs);
	        pos = pos + getAttackPostitions(n, r_q,c_q-1,0,-1,obs);
	        
	        pos = pos + getAttackPostitions(n, r_q + 1,c_q+1,1,1,obs);
	        pos = pos + getAttackPostitions(n, r_q - 1,c_q-1,-1,-1,obs);
	        pos = pos + getAttackPostitions(n, r_q + 1,c_q-1,1,-1,obs);
	        pos = pos + getAttackPostitions(n, r_q - 1,c_q +1,-1,1,obs);
	        
	        return pos;
	    }
	    static int getAttackPostitions(int n, int x, int y , int xmove, int ymove, Map<String,Integer> obs){
	        int pos = 0;
	        while( x>=1 && x<=n && y>=1 && y<=n && (obs.get("("+x +","+y +")")) == null){
	            x = x + xmove;
	            y = y+ ymove;
	            pos++;
	        }
	        return pos;
	    }
}
