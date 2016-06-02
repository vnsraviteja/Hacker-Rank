package com.accolite.problems;

import java.util.Stack;

public class tappingWater {
	public static void main(String [] args) {
		int [] input = {3, 0, 0, 2, 0, 4};
		int localMax = Integer.MIN_VALUE;
		int j=0;
		int waterCapacity = 0;
		Stack<building> s = new Stack<building>();
		building temp = null;
		for(int i = 0 ;i<input.length; i++) {
			if(s.isEmpty()){
				s.push(new building(input[i],i));
				continue;
			}
			if(s.peek().height >= input[i]) {
				s.push(new building(input[i],i));
			}
			else {
				while(!s.isEmpty() && s.peek().height < input[i]) {
					temp = s.pop();
					if(!s.isEmpty()) {
						waterCapacity =waterCapacity + (Integer.min(s.peek().height,input[i])-temp.height)*(i-1-s.peek().i);
					}
				}
				s.push(new building(input[i],i));				
			}
		}
		System.out.println(waterCapacity);
	}
}

class building {
	int i;
	int height;
	
	public building(int height,int i) {
		this.height = height;
		this.i = i;
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
