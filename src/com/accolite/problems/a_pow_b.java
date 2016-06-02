package com.accolite.problems;

public class a_pow_b {
	public static void main(String[] args) {
		for(int i=1;i<7;i++)
			System.out.println(pow_itr(3,i));
	}
	
	public static int pow(int a, int b) {
		if(b==0) 
			return 1;
		
		else {
			if(b%2 == 1) {
				return pow(a,b/2) * pow(a,b/2) * a;
			}
			else return pow(a,b/2) * pow(a,b/2);
		}
	}
	
	
	public static int pow_itr(int a, int b) {
		
		int prod = 1;
		
		while(b!=0) {
			if(b%2 == 1) {
				//a= a*a;
				prod = prod *  a;
			}

			a = a* a;
			b = b/2;
		}
		
		return prod;
	}
	
}
