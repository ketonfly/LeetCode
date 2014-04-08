package leecode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	
	
	public int evalRPN(String[] tokens) {

		String operations = "+-*/";

		Stack<String> stack = new Stack<String>();

		for (String token : tokens) {
			
			if (!operations.contains(token)) {
				stack.push(token);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				
				/*这样使用这个也是也可以的
				 * int index = operators.indexOf(t);
                switch(index)*/
				
				
				switch (token) {
				case "+":
					stack.push(String.valueOf(b + a));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				case "*":
					stack.push(String.valueOf(b * a));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;
				}
			}
		}
		
		return Integer.valueOf(stack.pop());
	}

	public static void main(String[] args) {
		EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
		String[] tokens = new String[] { "4", "13", "5", "/", "+" };
		System.out.println(e.evalRPN(tokens));
	}
}
