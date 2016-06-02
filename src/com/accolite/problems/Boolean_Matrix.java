package com.accolite.problems;

public class Boolean_Matrix {

	static int max_row = 0, max_column = 0;
	
	public static void main(String [] args) {
		int [][] input =  { {1, 0, 0, 0},
					        {0, 0, 0, 0},
					        {0, 1, 0, 0},
					        {0, 0, 0, 0}
		};
		max_row = 4;
		max_column = 4;
		parser(input);
		
	}
	
	public static void parser(int [][]input) {
		int i,j  ;
		for (i =0 ; i < max_row ; i++ ) {
			for(j=0; j<max_column; j++) {
				if(input[i][j] == 1) {
					dfs(input,i,j);
				}
			}
		}
		for (i =0 ; i < max_row ; i++ ) {
			for(j=0; j<max_column; j++) {
				if(input[i][j]== -1) {
					input[i][j] = 1;
				}
				System.out.print(input[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public static void dfs(int [][]input, int r,int c) {
		input[r][c]= -1;
		for(int i = 0; i<max_column; i++) {
			if(input[r][i] == 1) {
				dfs(input,r,i);
			}
			input[r][i] = -1;
		}
		for(int i = 0; i<max_column; i++) {
			if(input[i][c] == 1) {
				dfs(input,i,c);
			}
			input[i][c] = -1;
		}
	}
}
