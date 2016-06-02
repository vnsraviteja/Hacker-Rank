package com.accolite.testing;

public class HackerEarth {
	static int max =0 ;
	public static void main(String [] args) {
		int [] arr = {5, 6, 2, 1, 8, 2};
		int [] disp = {0,0,0,0,0};
		int N= arr.length;
		partition(arr,disp,0,N-1);
		int i;

		System.out.println(max);
	}

	public static int partition (int arr[],int disp[], int start,int end) {
		if(start > end) {
			return -1;
		}
		else if(start == end) {
			return start;
		}
		else {
			int i,j = start; 
			int key = arr[end];
			for( i = start; i<end; i++) {
				if(key >= arr[i]) {
					swap(arr,i,j);
					j++;
				}
			}
			swap(arr,i,j);

			partition(arr,disp,start,j-1);
			partition(arr,disp,j+1,end);

		}
		return 0;
	}

	public static void swap(int arr[], int i,int j) {
		if(Math.abs(i-j) > max) {
			max = Math.abs(i-j); 
		}
		int temp  = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
