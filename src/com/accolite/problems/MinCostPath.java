package com.accolite.problems;

public class MinCostPath {
	public static void main(String [] argss) {
		int n = 4;
		int [][] input = new int[n][n];
		int i,j,k,count=0;
		for(i =0 ;i<n;i++) {
			for(j=0;j<n;j++) {
				input[i][j] = count++;
			}
		}
		for(i = 0 ;i<n;i++) {
			for(j=0;j<n;j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		minCostPath(input,n);
	}
	
	public static int minCostPath(int [][] input,int n) {
		int i,j,k;
		int [][] output = new int[n][n];
		output[0][0] = input[0][0];
		for(i=1;i<n;i++) {
			output[0][i] = output[0][i-1]+input[0][i];
			output[i][0] = input[i][0] + output[i-1][0];
		}
		for(i=1;i<n;i++){
			for(j=i;j>0;j--){
			k=i-j+1;
			output[k][j] = (input[k][j] + (Math.min(Math.min(output[k-1][j], output[k][j-1]),output[k-1][j-1])));
			}
		}
		for(i=1;i<n;i++){
			k=n-1;
			for(j=i;j<n;j++){
			output[k][j] = (input[k][j] + (Math.min(Math.min(output[k-1][j], output[k][j-1]),output[k-1][j-1])));
			k--;
			}
		}
		for(i =0 ;i<n;i++) {
			for(j=0;j<n;j++) {
				System.out.print(output[i][j]+"    "); 			
			}
			System.out.println();
		}
		return 0;		
	}
}
