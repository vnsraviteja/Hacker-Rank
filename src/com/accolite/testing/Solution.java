package com.accolite.testing;
import java.util.HashMap;
import java.util.Map;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
	
	public static void main(String [] args) throws Exception {
			String s = "abcdefghij";
			char [] stringArray = s.toCharArray();
			boolean status = false;
			int k,numberOfColumns = 3;
			for(int i = 0; i<s.length(); ) {
				 k = i;
				 int q = i +( (i+numberOfColumns-1<s.length())? (numberOfColumns-1): (s.length()-i-1));
				 int limit = (i+numberOfColumns-1<s.length())? (numberOfColumns/2): (s.length()-i)/2;
				 while(status && k<q) {
					 char temp = stringArray[k];
					 stringArray[k] = stringArray[q]  ;
					 stringArray[q] = temp;
					 k++;
					 q--;
				 }
				 if(i%numberOfColumns == 0) {
					 status = !status;
				 }
				 i = i + numberOfColumns ;
			}
			
			for(int i =0; i<stringArray.length; i++) {
				System.out.println(stringArray[i]);
			}
	}
	
}