package com.accolite.problems;

public class spiralPrinting {
	public static void main(String [] args) {
		int x=3, y = 3,count= 0;
		int a[][] = new int[x][y];
		for(int i =0 ;i<x;i++) {
			for(int j=0;j<y;j++) {
				a[i][j] = count++;
			}
		}
		for(int i =0 ;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print(a[i][j] + "   ");
			}
			System.out.println();
		}
		
		printSpiral(a,x-1,y-1);
		return ;
	}

	private static void printSpiral(int[][] a, int xe, int ye) {
		int xs = 0,ys=0;

		while(true) {

			if(ye<ys && xe<xs) {
				break;
			}

			for(int j =ys;j<ye;j++) {
				System.out.print(a[xs][j] + "  ");
			}

			for(int i =xs;i<xe;i++) {
				System.out.print(a[i][ye] + "  ");
			}

			for(int j = ye;j>ys;j--) {
				System.out.print(a[xe][j]+ "  ");
			}
			
			for(int i =xe;i>xs;i--) {
				System.out.print(a[i][ys]+ "  ");
			}
			xs = xs+1;
			ys = ys+1;
			xe = xe -1;
			ye= ye-1;
			System.out.println();
		}
		
		
	}
}
