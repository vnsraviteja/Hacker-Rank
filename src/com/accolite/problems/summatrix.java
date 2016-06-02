package com.accolite.problems;

public class summatrix {
	public static int x=4, y = 4;
	public static void main(String [] args) {
		
		int count= 0;
		int input[][] = new int[x][y];
		int output[][] = new int[x][y];
		for(int i =0 ;i<x;i++) {
			for(int j=0;j<y;j++) {
				input[i][j] = count++;
			}
		}
		output[0][0]= input[0][0];
		createSumMatrix(input,output);
	}
	
	public static void createSumMatrix(int [][] input, int [][] output ){
		for(int i=1;i<x;i++) {
			output[0][i] = output[0][i-1] + input[0][i];
		}
		for(int i=1;i<y;i++) {
			output[i][0] = output[i-1][0] + input[i][0];
		}
		for(int i =1;i<x;i++){
			for(int j = 1; j<y;j++) {
				output[i][j] = output[i-1][j]+output[i][j-1]+input[i][j]-output[i-1][j-1];
			}
		}
	
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++) {
				System.out.print(input[i][j]+"  ");
			}
			System.out.println();
		}

		System.out.println();
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++) {
				System.out.print(output[i][j]+"  ");
			}
			System.out.println();
		}
		
	}
}
