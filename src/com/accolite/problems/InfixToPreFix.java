package com.accolite.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPreFix {

	public static Map<String,Integer> operatorRank = new HashMap<String,Integer> ();
	
	public static void main(String [] args){ 
		operatorRank.put("-", 0);
		operatorRank.put("+", 1);
		operatorRank.put("*", 2);
		operatorRank.put("/", 3);
		System.out.println(infixToPrefix("a/b+c*d-e"));
	}
	
	public static String infixToPrefix(String input) {
		Stack<String> vstack = new Stack<String> ();
		Stack<String> operator = new Stack<String> ();
		vstack.push(input.substring(0, 1));
		int length = input.length();
		for(int i = 1 ; i < length; i++ ) {
			Integer rank = operatorRank.get(input.substring(i,i+1));

			if(rank != null ) {
				if(!operator.isEmpty()) {
					Integer peek = operatorRank.get(operator.peek());
					while(rank < peek ) {
						
						String s = operator.pop() + " " + vstack.pop() + " " + vstack.pop();
						vstack.push(s);
						peek = (operator.isEmpty() ? -1: operatorRank.get(operator.peek()));
					}
				}
	
				operator.push(input.substring(i, i+1));
			}
			else {
				vstack.push(input.substring(i,i+1));
			}
		}
		while(!operator.isEmpty()) {
			String s = operator.pop() + " " + vstack.pop() + " " + vstack.pop();
			vstack.push(s);
		}
		return vstack.peek();
	}
}
