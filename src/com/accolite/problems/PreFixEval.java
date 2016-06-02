package com.accolite.problems;

import java.util.Stack;

public class PreFixEval {
	static int start = 0;
	public static void main(String [] args) {
		String s = "(+ 3 (* 5 2) (- 6 3))";
		System.out.println(evalExp(s));
	}
	
	public static int evalExp(String s){
		Integer val = null ;
		char temp;
		char oper = ' ';
		Integer num = null;
		boolean flag = false;
		while(start<s.length()) {
			temp = s.charAt(start);
			switch(temp) {
				case ' ': {				
					if(flag == true && val!=null){
						switch(oper){
							case '*' :{
								val *=  num;
								break;
							}
							case '+': {
								val += num;
								break;
							}
							case '-': {		
								val -= num;
								break;
							}
							case '/': {
								val /= num;
								break;
							}
							default: {
								break;
							}
						}
					}
					if(val == null) {
						val = num;
					}
					
					flag = false;
					num = null;
					break;
				}
				case '(': {
					start++;
					num = evalExp(s);
					flag=true;
					break;
				}
				case ')': {
					if(flag == true){
						switch(oper){
							case '*' :{
								val *=  num;
								break;
							}
							case '+': {
								val += num;
								break;
							}
							case '-': {		
								val -= num;
								break;
							}
							case '/': {
								val /= num;
								break;
							}
							default: {
								break;
							}
						}
					}
					return val;
				}
				case '*' : {
					oper = '*';
					break;
				}
				case '+' : {
					oper = '+';
					break;
				}
				case '-' : {
					oper = '-';
					break;
				}
				case '/' : {
					oper = '/';
					break;
				}
				default: {
					if(num == null) {
						num = 0;
					}
					num = num*10+(s.charAt(start)-'0');
					flag = true;
					break;
				}
			};
			start++;
		}

		return num;
	}
	


}


