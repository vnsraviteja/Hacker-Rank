package com.accolite.testing;
/* package whatever; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Long hr,min,sec;
		String phone;
		String input = "00:01:07,400-234-090 \n"+
						"00:05:01,701-080-080 \n"+
						"00:05:00,400-234-090 \n";		
		String [] logs = input.split("\\r?\\n");
		Map<String,Long> m = new HashMap<String,Long>();
		String maxCallNumber = null;
		Long max = 0L;
		for(String s: logs) {
			String[] dur_num_split = s.split(",");
			String[] fields = dur_num_split[0].split(":");
			hr = Long.valueOf(fields[0]);
			min = Long.valueOf(fields[1]);
			sec = Long.valueOf(fields[2]);
			Long time = hr*60*60+min*60+sec;
			Long prevTime = m.get(dur_num_split[1]);
			if(prevTime==null) {
				m.put(dur_num_split[1], time);
			}
			else {
				m.put(dur_num_split[1],prevTime+time);
			}
			if(max < prevTime+time) {
				max = prevTime+time;
				maxCallNumber = dur_num_split[1];
			}
			else if(max == prevTime+time) {
				if(maxCallNumber.compareTo(dur_num_split[1]) == -1) {
					maxCallNumber = dur_num_split[1];
				}
			}
			
		}
		
		
		
			

		
		
		
	}
}