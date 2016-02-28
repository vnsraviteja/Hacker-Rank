package com.accolite.backtraking;

import java.util.Iterator;
import java.util.Stack;

public class Subsequence {

	public static void main(String args[]) {
		int a[] = { 1, 2, 3, 4, 5, 6 };
		printSubsequence(a, 0, new Stack());
	}

	public static void printSubsequence(int[] a, int index, Stack s) {
		if (index >= a.length) {
			print(s);
		} else {
			s.push(a[index]);
			printSubsequence(a, index + 1, s);
			s.pop();
			printSubsequence(a, index + 1, s);
		}
	}

	public static void print(Stack s) {
		Iterator itr = s.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + "  ");
		}
		System.out.println();
	}
}
