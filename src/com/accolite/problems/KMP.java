package com.accolite.problems;

public class KMP {

	public static void main(String [] args) {
		int [] arr  = pi("ABABACAC");
		for(int i = 0; i<arr.length; i++ ) {
			System.out.println(arr[i]);
		}
	}
	
	public static int [] pi(String input) {
		int size = input.length();
		int[] piArr = new int [size];
		int j = -1;
		piArr[0] = 0;
		for(int i = 1; i< size ; i++ ) {
			int k = piArr[i-1];
			while(true) {
				if(input.charAt(k) == input.charAt(i)) {
					k++;
					break ;
				}
				else if(k == 0) {
					break;
				}
				else {
					k = piArr[k];						
				}
			}
			piArr[i] = k;
		}		
		return piArr;
		
	}
	
}

