package com.accolite.testing;

public class Indeed {
	public static void main(String [] args) {
		String s = "358/472+301/417";
		String delims = "[/\\+]";
		String [] tokens = s.split(delims);
		boolean a =false;
		/*if(a = true) {
			System.out.println("hello");
		}
		else{ 
			System.out.println("gooddby");
		}*/
		
		System.out.println(isPower(216L));
		
	}
	
	public static String  addFraction(String [] tokens) {
		long [] denominators = new long[tokens.length/2];
		long [] numerators = new long[tokens.length/2];
		int j =0;
		for(int i = 1; i<tokens.length; ) {
			numerators[j] = Long.parseLong(tokens[i-1]);
			denominators[j++] = Long.parseLong(tokens[i]);
			i=i+2;
		}
		long l = lcm(denominators);
		j = 0;
		long sum = 0;
		for(int i=0;i<tokens.length/2;i++) {
			long q = l/denominators[i];
			sum = sum+ q*numerators[i];
		}
		long g = gcd(sum,l);
		
		Integer Num = (int) ((int) sum/g);
		Integer Dem = (int) ((int) l/g);
		String s = Num.toString()+ "/" + Dem.toString();
		return s;
		
	}

	private static long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}

	private static long lcm(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}
	
	private static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; 
	        a = temp;
	    }
	    return a;
	}
	
	private static	boolean isPower(Long n)
	{
	    
	    if (n <= 1) return true;
	 
	    // Try all numbers from 2 to sqrt(n) as base
	    for (long x=2L; x<=Math.sqrt(n); x++)
	    {
	        long  p = x,q=n;
	        
	        // Keep multiplying p with x while is smaller
	        // than or equal to x
	        while (true)
	        {
			         if(gcd(p,q) == p && q!=p){
			        	 q=q/p;
		         	}
			         else if(q==p) {
			        	 return true;
			         }
			         else {
			        	 break;
			         }
	        }
	    }
	    return false;
	}

}
