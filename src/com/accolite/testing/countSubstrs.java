package com.accolite.testing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class countSubstrs {
	public static void main(String [] args) {
		String s = "abba";
		System.out.println(countVariable(s));
		}
	public static int countVariable(String s) {
		int count =0 ;
		Map<Character,LinkedList<Integer>> m = new HashMap<Character,LinkedList<Integer>>();
		for(int i = 0 ; i<s.length(); i++) {
			LinkedList l = m.get(s.charAt(i));
			if(l != null) {
				int max = 0;
				Iterator itr = l.iterator();
				while(itr.hasNext()) {
					int idx = (int) itr.next();
					int k = i;
					for(int j = idx; j < s.length() && k < s.length(); j++,k++ ) {
						if(s.charAt(j) != s.charAt(k)) {
							break;
						}
					}
					if(max < k) {
						max = k;
					}
				}
				count = count + s.length() - max;
				l.add(i);
				m.put(s.charAt(i), l);
			}
			else {
				count = count + s.length()-i;
				LinkedList nl = new LinkedList();
				nl.add(i);
				m.put(s.charAt(i), nl);
			}
		}
		return count;
	}
}
