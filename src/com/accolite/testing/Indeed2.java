package com.accolite.testing;

import java.util.HashMap;
import java.util.Map;

public class Indeed2 {
	public static void main(String []args) {
		int [] input = { 1, 2, 1, 2, 1, 2};
		System.out.println(countSum(input,2));
	}
	
	public static int countSum(int [] input, int k) {
		int count = 0;
		int sum = 0;
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		for(int i = 0 ;i<input.length; i++) {
			sum = sum + input[i];
			int index = sum % k ;
			Integer temp = m.get(index);
			if(index == 0) {
				count++;
			}
			temp = m.get(index);
			if(temp != null) {
				count = count + temp;
			}
			if(temp != null) {
				m.put(index, temp +1);
			}
			else {
				m.put(index, 1);
			}
			
		}
		return count;
	}
}
