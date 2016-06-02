package com.accolite.tree.testing;

public class Check2TreeHaveSameStruct {
	public static void main(String []args) {
		int [] a = {2,1,3,4,5};
		int [] b = {2,3,1,5,4};
		createPreOrderArr(a,0,a.length);
		createPreOrderArr(b,0,b.length);
		for(int i = 0 ; i<a.length;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		for(int i = 0 ; i<b.length;i++){
			System.out.print(b[i] + " ");
		}
	}
	
	public static void createPreOrderArr(int [] input, int s, int e){
		if(s>=e) {
			return ;
		}
		else {
			int j =s;
			for(int i = s; i<e; i++){
				if(input[s] >= input[i]) {
					swap(input,i,j);
					j++;
				}
			}
			createPreOrderArr(input,s+1,j);
			createPreOrderArr(input,j+1,e);
		}
	}
	
	public static void swap(int []arr, int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
