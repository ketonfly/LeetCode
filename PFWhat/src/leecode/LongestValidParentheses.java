package leecode;

import java.util.Stack;

public class LongestValidParentheses {
	
	 public int ClongestValidParentheses(String s) 
	 {
	     int countMax = 0;
	     int start = -1;
	     Stack<Integer> stack = new Stack<Integer>();
	      
	     for(int i = 0;i<s.length();i++) {
	    	 char ch=s.charAt(i); 
	    	 if(ch=='('){
	    		 stack.push(i);
	    	 }
	     	else if(stack.isEmpty()){
	     		start=i;
	     		stack.pop();
	     		countMax=countMax>(i-start)?countMax:(i-start);
	                 }
	                 else
	                 {
	                     countMax = countMax>(i-stack.get(stack.size()-1))?countMax:(i-stack.get(stack.size()-1));
	                 }
	             }
	     
	     return countMax;
	 }
	
	
	
	
	public int longestValidParentheses(String s) {
		int l = s.length();
		if (l == 0) {
			return 0;
		}
		char c[] = s.toCharArray();
		int flag[] = new int[l];
		for (int i = 0; i < l; i++) {
			if (c[i] == '(') {
				flag[i] = 1;
			}
			if (c[i] == ')') {
				flag[i] = -1;
			}
		}
		int max = 0;
		int sum = 0;
		for (int i = 0; i < l;) {
			if (flag[i] == 1) {
				sum = flag[i];
				int j ;
				for (j=i+1; j < l; j++) {
					sum = sum + flag[j];
					if(sum < 0){
						max =Math.max(j-i+1+sum, max);
						break;
					}
					else max =Math.max(j-i+1-sum, max);
				}
				i = j+1;
				
			} else {
				i++;
			}

		}
		return max;
	}

	// 理解错题意了，以为就是标准的，valid 包括括号中有括号
	public int WlongestValidParentheses(String s) {
		int l = s.length();
		if (l == 0) {
			return 0;
		}
		int flag[] = new int[l];
		char c[] = s.toCharArray();
		if (c[0] == '(')
			flag[0] = 1;
		if (c[0] == ')')
			flag[0] = 1;
		for (int i = 1; i < l; i++) {
			if (c[i] == '(') {
				if (flag[i - 1] % 2 == 0) {
					flag[i] = flag[i - 1] + 1;
				} else
					flag[i] = 1;
			}
			if (c[i] == ')') {
				if (flag[i - 1] % 2 == 1) {
					flag[i] = flag[i - 1] + 1;
				} else
					flag[i] = 1;
			}
		}
		int max = 0;
		for (int i = 0; i < l; i++) {
			if (flag[i] % 2 == 0 && flag[i] > max) {
				max = flag[i];
			}
		}
		return max;
	}
}
