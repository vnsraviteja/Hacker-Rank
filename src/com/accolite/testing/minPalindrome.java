package com.accolite.testing;

public class minPalindrome {
	public static void main(String [] args) {
		String s = "abab";
		int [][] count = new int[s.length()][s.length()];
		System.out.println(minCount(count,s,0,s.length()-1));
	}
	
	public static int minCount(int count[][],String s,int start,int end) {
		
		if(start > end){
			return 0;
		}
		else if(start == end) {
			count[start][end] = 0;
			return 0;
		}
		else {
			if(count[start][end]!=0) {
				return count[start][end];
			}
			else {
				if(s.charAt(start) == s.charAt(end)){
					count[start][end] = minCount(count,s,start+1,end-1);
					return count[start][end];
				}
				else {
					int first = minCount(count,s,start+1,end);
					int last = minCount(count,s,start,end-1);	
					count[start][end] = (first > last)? last+1 : first+1;
					return count[start][end];
				}
			}
		}
	}
}
