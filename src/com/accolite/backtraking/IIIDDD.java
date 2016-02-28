package com.accolite.backtraking;

import java.util.Iterator;
import java.util.Stack;

public class IIIDDD {

	public static boolean[] status = new boolean[9];

	public static void main(String args[]) {

		String[] pattern = { "I", "D", "II", "ID", "DI", "DD", "IDID", "DIDI", "IIDDD", "DDIDDIID" };
		Stack s = new Stack();
		for (int i = 0; i < pattern.length; i++) {
			if(pattern[i].charAt(0)=='I'){
				s.push(1);
				status[0] = true;
			}
			else {
				s.push(2);
				status[1] = true;
			}
			PrintMinNumberForPattern(pattern[i], 0, s);
		}
	}

	private static void PrintMinNumberForPattern(String input, int index, Stack s) {
		if (input.length() < 9) {
			if (index < input.length()) {
				if (input.charAt(index) == 'I') {
					int succ = successor((Integer)s.peek());
					if(succ != 0) {
						status[succ-1] = true;
						s.push(succ);
						PrintMinNumberForPattern(input,index+1,s);
					}
					/*else {
						int top =(Integer)s.peek();
						status[top-1] = false;
						s.pop();
						top = (Integer)s.peek();
						PrintMinNumberForPattern(input,index-1,s);
					}*/
				} else {
					int pre = predecessor((Integer)s.peek());
					if(pre != 0 ) {
						status[pre-1] = true;
						s.push(pre);
						PrintMinNumberForPattern(input,index+1,s);
					}
					else {
						
					}
				}
			} else {
				return;
			}
		} else {
			for (int i = 0; i < 9; i++) {
				System.out.print("9  ");
			}
			System.out.println();
		}

	}

	public static void print(Stack s) {
		Iterator itr = s.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + "  ");
		}
		System.out.println();
	}

	public static boolean isAvailable(int t) {
		if (status[t - 1] == true) {
			return true;
		} else
			return false;

	}

	public static int successor(int key) {
		for (int i = key-1; i < status.length; i++) {
			if (!status[i]) {
				return i+1 ;
			}
		}
		return 0;
	}
	
	public static int predecessor(int key) {
		for (int i = key-1; i > 0; i--) {
			if (!status[i]) {
				return i+1;
			}
		}
		return 0;
	}
}
