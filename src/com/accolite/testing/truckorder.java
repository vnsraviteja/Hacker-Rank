package com.accolite.testing;

import java.util.Stack;

public class truckorder {
	public static void main(String[] args) {
		int i =0 ;
		int [] arr = {5,4,1,2,0,3};
		System.out.println(checkTruck(arr));
	}
	
	public static boolean checkTruck(int [] arr) {
		boolean result ;
		Stack<Integer> s = new Stack<Integer>();
		int current_max = Integer.MIN_VALUE;
		for(int i =0 ; i<arr.length; i++) {
			if(arr[i] > current_max) {
				if(s.isEmpty()) {
					s.push(arr[i]);
				}
				else if(!s.isEmpty() && s.peek() > arr[i]) {
					s.push(arr[i]);
				}
				else if(!s.isEmpty() && s.peek() < arr[i]) {
					while(!s.isEmpty() && s.peek() < arr[i]) {
						current_max = s.peek();
						s.pop();
					}
					s.push(arr[i]);
				}
			}
			else return false;
		}
		return true;	
	}
}

