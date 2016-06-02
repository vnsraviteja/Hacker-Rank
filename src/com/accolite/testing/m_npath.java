package com.accolite.testing;

public class m_npath {

	public static void main(String args[]){
		int x,y,size =5;
		int [][] input = new int[size][size];
		
		for(int i = 0 ; i <size ; i++) {
			x=i;
			y=i;
			while(x<size) {
				if(i==0) {
					input[i][x] = 1;
				}
				else {
					input[i][x] = input[i-1][x] + input[i][x-1];
				}
				x++;
			}
			while(y<size) {
				if(i==0) {
					input[y][i]=1;
				}
				else {
					input[y][i]= input[y][i-1]+input[y-1][i];
				}
				y++;
			}
			
		}
		for(int i = 0 ; i<size ; i++){
			for(int j=0; j<size; j++) {
				System.out.print(input[i][j] + "  ");
			}
				System.out.println();
		}

	}
	

}
