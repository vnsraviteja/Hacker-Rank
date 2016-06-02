package com.accolite.testing;


import java.util.Scanner;

public class techmojo {
	public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        int n,x,y;
        while(count > 0 ) {
        	n=s.nextInt();
        	x=s.nextInt();
        	y=s.nextInt();
        	System.out.println(Integer.max(x, n-y));
        }
	}
}
