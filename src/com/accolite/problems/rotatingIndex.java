package com.accolite.problems;

public class rotatingIndex {
	
	public static void main(String [] args) {
		int [] input = {1,3,4,5,8,9,12,23} ;
	//	System.out.println(rotatingIndex(input,0,input.length-1));
	//	System.out.println(search(input,0,input.length-1,1));
	//	System.out.println(peekIndx(input,0,input.length-1));
		System.out.println(nearestNeighbour(input,0,input.length-1,7));
	}
	public static int rotatingIndex(int [] input, int start,int end) {
		int mid = (start+end)/2;
		if(end-start >1) {
			if(input[mid] > input[0]) {
				if(input[mid+1] <= input[0]) 
					return mid+1;
				else {
					return rotatingIndex(input,mid+1,end);
				}
			}
			else {
				if(input[mid-1] >= input[0]) {
					return mid;
				}
				else {
					return rotatingIndex(input,start,mid-1);
				}
			}
		}
		else {
			return (input[end] > input[start] ? (input[start] < input[0]? start: 0): (input[end] < input[0]? end: 0) );
		}
	}
	
	public static int search(int []input,int start,int end,int key) {
		int mid = (start+end)/2;
		if(end-start>1) {
			if(input[mid] == key) {
				return mid;
			}
			else if(input[mid] < key) {
				if(input[start] >= key) {
					return search(input,start,mid-1,key);
				}
				else return search(input,mid+1,end,key);
			}
			else if(input[mid] > key) {
				if(input[start] <= key) {
					return search(input,start,mid-1,key);
				}
				else return search(input,mid+1,end,key);
			}
		}
		else {
			return (input[start]==key ? start: (input[end]==key ? end : -1));
		}
		return 0;
	}

	public static int findMin(int arr[], int low, int high)
	{
	    // This condition is needed to handle the case when array is not
	    // rotated at all
	    if (high < low)  return arr[0];
	 
	    // If there is only one element left
	    if (high == low) return arr[low];
	 
	    // Find mid
	    int mid = low + (high - low)/2; /*(low + high)/2;*/
	 
	    // Check if element (mid+1) is minimum element. Consider
	    // the cases like {3, 4, 5, 1, 2}
	    if (mid < high && arr[mid+1] < arr[mid])
	       return arr[mid+1];
	 
	    // Check if mid itself is minimum element
	    if (mid > low && arr[mid] < arr[mid - 1])
	       return arr[mid];
	 
	    // Decide whether we need to go to left half or right half
	    if (arr[high] > arr[mid])
	       return findMin(arr, low, mid-1);
	    return findMin(arr, mid+1, high);
	}

	public static int peekIndx(int []input,int start,int end) {
		int mid = (start + end)/2;
		if(end-start>1) {
			if(input[mid-1] < input[mid] && input[mid] > input[mid+1]) {
				return mid;
			}
			else if(input[mid] > input[mid+1]) {
				return peekIndx(input,start,mid);
			}
			else {
				return peekIndx(input,mid+1,end);
			}
		}
		else {
			return (input[start] > input[end] ? start: end);
		}
	}
	
	public static int nearestNeighbour(int []input,int start,int end,Integer key) {
		int mid = (start+end)/2;
		if(end-start>1) {
			if(input[mid]>= key && input[mid-1] <= key) {
				return (Math.abs(input[mid] - key) > Math.abs(input[mid-1]-key)? mid-1: mid);
			}
			else if(input[mid]> key ) {
				return nearestNeighbour(input,start,mid-1,key);
			}
			else {
				return nearestNeighbour(input,mid,end,key);
			}
		}
		else{
			return (Math.abs(input[start] - key) > Math.abs(input[end]-key)? end: start);
		}
	}
}
