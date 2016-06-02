package com.accolite.testing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baskets {
	
	static int minToggles = Integer.MAX_VALUE;
	static int order [] = new int[3], totalCount []= new int[3];;
	static int [][] input = new int[3][3] ;
	public static void main(String [] args) {
		
		int i,j;
		System.out.println("please enter the input");
		Scanner s = new Scanner(System.in);
		for (i =0 ;i<3;i++) {
			for(j=0;j<3;j++) {
				input[i][j] = s.nextInt();
			}
		}
		sortColumns(input);
		for(j =0 ;j<3; j++) {
			int total =0 ;
			for(i = 0 ;i<3;i++) {
				total = total + input[i][j];
			}
			totalCount[j] = total;
		}
		int [] output = {0,1,2};
		Map<Integer,String> hm = new HashMap<Integer,String> ();
		hm.put(0, "B");
		hm.put(1, "S");
		hm.put(2, "W");
		permutate(output,0,2);
		for(i = 0 ; i<3;i++) {
			System.out.print(hm.get(order[i]));
		}
		System.out.println("  "+ minToggles );

	}



	private static void sortColumns(int[][] input) {
		int a,b =0;
		for (int i =0 ;i<3;i++) {
			a = input[i][0];
			b = input[i][1];
			input[i][1] = input[i][2];
			input[i][2] = a;
			input[i][0] = b;
		}
	}
	
	private static void permutate (int[] output,int i,int j  ) {
		if(i == j) {
			int count=0;
			for(int k =0 ;k<=j; k++) {
				count = count + totalCount[output[k]]-input[k][output[k]];
			}
			if(count<minToggles ) {
				minToggles  = count;
				for(int k =0 ;k<=j; k++) {
					order[k] = output[k];
				}
			}
		}
		else {
			for(int k = i ; k<=j ; k++ ) {
				swap(output,i,k);
				permutate(output,i+1,j);
				swap(output,i,k);
			}
		}
	}

	private static void swap(int arr[], int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

 }
