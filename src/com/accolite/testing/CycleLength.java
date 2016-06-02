package com.accolite.testing;


import java.util.*;


public class CycleLength {
	
	public static Map <Integer,Integer> hm = new HashMap<Integer,Integer>();
	public static void main(String []args){
	
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		Scanner scanIn = new Scanner(System.in);
		int x,y,temp = 0;
		System.out.println("Enter x value");
		x= scanIn.nextInt();
		System.out.println("Enter y value");
		y=scanIn.nextInt();
		int g_max = Integer.MIN_VALUE;
		hm.put(1, 1);
		for(int i=x;i<=y;++i){
			temp = calculateLength(i);
			
			if(temp>g_max){
				g_max = temp;
			}
		}
		System.out.println(g_max);
		
	}
	
	public  static int calculateLength(int n){
		if(n<=0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		int next=0,temp;
		
		if(n%2 == 0){
			next = n/2;
		}
		else if(n%2 == 1){
			next = 3*n+1;
		}
		
		if(hm.get(n) != null) {
			return hm.get(n);
		} 
		else {
			temp = 1+calculateLength(next);
			hm.put(n,temp);
		}
		return temp;
	}

}