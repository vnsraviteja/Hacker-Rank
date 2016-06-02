package com.accolite.problems;

import java.util.Iterator;
import java.util.Stack;

public class K_Paths {
	
	public static Stack<coordinates> path = new Stack<coordinates> (); 
	public static void main(String [] args) {
		int k = 12;
		int mat[][] = { {1, 2, 3},
		                    {4, 6, 5},
		                    {3, 2, 1}
		                  };
		System.out.println(countPath(mat,3,0,0,12));
	}
	
	public static void countPath(int [][] input, int key) {
		Stack<coordinates> path = new Stack<coordinates> (); 
		
		if(key == 0) {
			Iterator<coordinates> iterator = path.iterator();
			while(iterator.hasNext()) {
				coordinates c = iterator.next(); 
				System.out.println(input[c.x][c.y]);
			}
		}
		else {
			while(path.isEmpty()) {
				
			}
		}
		
	}
	
	public static int countPath(int [][]input,int n, int i,int j,int key) {
		
		if(i>=n || j >= n) {
			return 0;
		}
		else{
			key = key - input[i][j];
		}
		if(key == 0) {
			path.push(new coordinates(i,j));
			Iterator<coordinates> iterator = path.iterator();
			while(iterator.hasNext()) {
				coordinates c = iterator.next(); 
				System.out.print(input[c.x][c.y]+"  ");
			}
			System.out.println();
			path.pop();
			return 1;
		}
		else {
			path.push(new coordinates(i,j));	
			int down= countPath(input,n,i+1,j,key);
			int right = countPath(input,n,i,j+1,key);
			path.pop();
			return right + down;
		}
	}
	
}

class coordinates{
	public int x,y;

	public coordinates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}
