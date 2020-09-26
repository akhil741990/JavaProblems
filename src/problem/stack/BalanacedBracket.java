package problem.stack;

import java.util.Stack;

public class BalanacedBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "{[(})]}";
		int flag  = 0;
		Stack<Character> stack = new Stack();
		for(int i =0; i < s.length();i ++){
			if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
				stack.push(s.charAt(i));
			}else{
				if(stack.isEmpty()){
					flag = 1;
					break;
				}else {
					char top = stack.pop();
					if(s.charAt(i)==')' && top != '('){
						flag = 1;
						break;
					}else if(s.charAt(i)=='}' && top != '{'){
						flag = 1;
						break;
					}else if(s.charAt(i)==']' && top != '['){
						flag = 1;
						break;
					}
				}
			}
			
		}
		if(flag ==0 && stack.isEmpty()){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

}
