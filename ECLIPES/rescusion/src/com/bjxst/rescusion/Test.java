package com.bjxst.rescusion;

public class Test {
	public static void main(String[] args) {
		System.out.println(method(6));
	}
	public static int method(int n){
		if(n == 1)
			return 1;
		else 
			return n*method(n-1);
		
	}
}
