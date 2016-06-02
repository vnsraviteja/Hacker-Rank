package com.accolite.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class adobe {
	public static void main(String [] args) {
		String s = "ebcadef" ;
		String min = null;
		String max = null;
		boolean flag= false;
		Set<Character> vowels = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
		int i,j=0;
		for( i=0;i<s.length();i++) {
			if(vowels.contains(s.charAt(i))&&!flag){
				flag = true;
				j = i;
			}
			if(!vowels.contains(s.charAt(i)) && flag){
				while(j<i){
					if(min == null){
						min = s.substring(j, i+1);
					}
					else if(min.compareTo(s.substring(j, i+1))>0){
						min = s.substring(j, i+1);
					}
					j++;
				}
				flag = false;
			}
		}
		j = -1;
		flag = false;
		for(i=0;i<s.length();i++) {
			if(vowels.contains(s.charAt(i))){
				if(j>=0 &&flag){
					if(max == null){
						max = s.substring(0, i);
					}
					else if(max.compareTo(s.substring(j, i))<0){
						max = s.substring(j, i);
					}
					else {
						max = max.concat(s.substring(j,i));
					}
				}
				j = i;
				flag = false;
			}
			else {
				flag = true;
			}
			
		}
				
		if(j>=0 &&flag){
			if(max == null){
				max = s.substring(0, i);
			}
			else if(max.compareTo(s.substring(j, i))<0){
				max = s.substring(j, i);
			}
			else {
				max = max.concat(s.substring(j,i));
			}
		}
		System.out.println(min);
		System.out.println(max);
		
	}
}	
