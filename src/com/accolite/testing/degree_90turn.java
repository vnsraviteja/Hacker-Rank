package com.accolite.testing;

public class degree_90turn {
	
	public static void main(String []args) {
		int i,j,size =6,count=0;
		int min_r=0,max_r=size-1; 
		int min_c=0,max_c=size-1;
		int [][] input = new int[size][size];
		
		for(i=0;i<size;i++) {
			for(j=0;j<size;j++) {
				input[i][j] = count++;
			}
		}
		for(i=0;i<size;i++){
			for(j=0;j<size;j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		printDiagonal(size,input);
		//rotateMatrix(size-1,input,0);
/*		for(i=min_r;i<max_r/2;i++){
			max_c = size - 1-i; 
			for(j=i;j<max_c;j++){
				int temp = input[j][max_c];
				input[j][max_c]=input[i][j];
				int temp2 = input[max_c][max_c-j+i];
				input[max_c][max_c-j+i]=temp;
				temp = input[max_c-j+i][i] ;
				input[max_c-j+i][i] = temp2 ;
				input[i][j] = temp;
			}
		}
*/		
		/*
		for(i=min_r;i<=max_r/2;i++){
			max_c = size - 1-i; 
			for(j=i;j<max_c;j++){
				int temp = input[j][max_c];
				input[j][max_c]=input[i][j];
				int temp2 = input[max_c][max_r-j];
				input[max_c][max_r-j]=temp;
				temp = input[max_r-j][i] ;
				input[max_r-j][i] = temp2 ;
				input[i][j] = temp;
			}
		}
		printMatrix(size,input);	*/
	}
	
	public static void printDiagonal(int size,int [][] input) {
		for(int i =0 ;i<2*size-1;i++) {
			int k = (i>size-1)? size-1: i;
			int j=(i>size-1)? i-(size-1):0;
			while(k>=0&&j<size) {
				System.out.print(input[k--][j++]+" ");
			}
			System.out.println();
		}
	}
	public static void rotateMatrix(int size,int [][] input,int min_r) {
		
		if(min_r<=size/2){
			for(int i = 0 ; i<size-min_r*2;i++){
				int temp = input[i+min_r][size-min_r];
				input[i+min_r][size-min_r] = input[min_r][i+min_r];
				int temp2 = input[size-min_r][size-min_r-i];
				input[size-min_r][size-min_r-i] = temp;
				temp=input[size-min_r-i][min_r];
				input[size-min_r-i][min_r] = temp2;
				input[min_r][i+min_r]=temp;
			}
			rotateMatrix(size,input,min_r+1);
		}
		else return ;
		
		
		}

	
	public static void printMatrix(int size,int [][] input){
		int j,i;
		for(i=0;i<size;i++){
			for(j=0;j<size;j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
