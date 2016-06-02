package com.accolite.backtraking;

public class MinimumJumps {
	public static void main(String [] args) {
		int arr[] = {3, 2,3,1,1,1,1,1};
		System.out.println(minJumps(arr,0,0));
		System.out.println("min jumps are");
		System.out.println(minJumps(arr));
	}
	
	public static int minJumps(int [] input,int idx,int n){
		if(idx>=input.length || n >= input.length) {
			return 0;
		}else {
			if(n==0) {
				return 1+minJumps(input,idx+1,n-1+input[idx]);
			}
			else {
				return Math.min(1+minJumps(input,idx+1,n-1+input[idx]),minJumps(input,idx+1,n-1));
			}
		}
	}
	
	public static int minJumps(int [] arr) {
		int n = arr.length;
		  int [] jumps = new int[n];  // jumps[n-1] will hold the result
		  int i =1, j = 0;

		  jumps[0] = 0;
		  for (i = 1; i < n; ) { 

		    // if i is out of range of arr[j], then increment j
		    if (arr[j] + j < i && j < i) {

		      j++;

		    // else if i is within range of arr[j], 
		    //   jumps for ith element would be jumps[j]+1
		    } else if (arr[j] + j >= i && j < i) {

		      jumps[i] = jumps[j] + 1;
		      i++;

		    } else {
		      System.out.println("solution does not exist");
		      return -1;
		    }
		  }

		  System.out.println("jumps: ");
		  /*for (i = 0; i < n; i++) {
			  System.out.println(jumps[i]);
		  }*/
		  return jumps[n - 1];

	}
}
