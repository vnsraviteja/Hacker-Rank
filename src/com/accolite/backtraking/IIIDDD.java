package com.accolite.backtraking;

import java.util.Iterator;
import java.util.Stack;

public class IIIDDD {
	public static Stack<Integer> numStack  = new Stack<Integer>(); 
	
	public static void main(String args[]) {
		String [] other = {"I", "D", "II", "ID", "DI", "DD", "IDID", "DIDI"};
		String[] pattern = {"I", "D", "II", "ID", "DI", "DD", "IDID", "DIDI", "IIDDD",  "DDIDDIID" };
		for (int i = 0; i < pattern.length; i++) {
			numStack.push(1);
			printMinNumber(pattern[i],0);
			printStack(numStack);
		}
	}
	
	private static void printMinNumber(String input,int indx) {
		int num = numStack.peek();
		if(indx < input.length()) {
			if(input.charAt(indx) == 'I') {
				numStack.push(num+1);
				printMinNumber(input,indx+1);
			}
			else if(input.charAt(indx) == 'D') {
				if(num > 1) {
					numStack.push(num-1);
					printMinNumber(input,indx+1);
				}
				else {
					int i = indx-1;
					while(i>=0) {
						if(input.charAt(i)== 'I') {
							numStack.push(numStack.pop()+1);
							printMinNumber(input,i+1);
							break;
						}
						else {
							numStack.pop();
							i--;
						}				
					}
					if(i == -1) {
						numStack.push(numStack.pop()+1);
						printMinNumber(input,0);
					}
				}
			}
		}
		else return;
	}
	
	public static void printStack(Stack s) {
		Stack s_new = new Stack() ;
		while(!s.isEmpty()){
			s_new.push(s.pop());
		}
		while(!s_new.isEmpty()) {
			System.out.print(s_new.pop());
		}
		System.out.println();
	}
}
