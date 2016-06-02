package com.accolite.problems;

public class MaxSumSubsequence {
	
	public static String output = "";
	public static void main(String [] args) {
		int [] arr = {10, 5, 4, 3};
		System.out.println(max_sum(arr));
//		System.out.println(max_sum(arr,0,Integer.MIN_VALUE));
//		System.out.println(output);
	}
	
	public static int max_sum(int [] input,int ind, int max) {
		int consider = 0,unconsider =0 ;
		if(ind < input.length) {
			if(input[ind] > max) {
				consider = input[ind]+ max_sum(input,ind+1,input[ind]);
			}
				unconsider = max_sum(input,ind+1,max);
				if(consider > unconsider) {
					output = input[ind] + "  " + output;
				}
				return (consider > unconsider)? consider: unconsider;			
		}
		else return 0;
	}
	
	public static int max_sum(int [] input ) {
		int [] output = new int[input.length];
		int m =0 ;
		for(int i = 0  ; i<input.length; i++) {
			{
				int j = i;
				int max = 0;
				while(j>=0) {
					if(input[i] > input[j] && max < output[j]) {
						max = output[j];
					}
					j--;
				}
				output[i] = max+input[i];
			}
		}
		m = output[0];
		for(int i=0;i<output.length;i++) {
			if(m<output[i]) {
				m = output[i];
			}
		}
		
		return m;
	}
	
}
