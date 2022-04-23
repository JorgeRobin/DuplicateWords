package com.coderbyte;

import java.util.Scanner;
import java.util.stream.LongStream;

public class Factorial {

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    String test = s.nextLine();
	    System.out.println(factorialWithLoop(Integer.parseInt(test)));
	    System.out.println(factorialUsingStreams(Integer.parseInt(test))); 
	    System.out.println(factorialUsingRecursion(Integer.parseInt(test))); 
	}
	
	public static int factorialWithLoop(int num) {
	    int fact = num;
	    for (int i = num - 1; i > 1; i--) {
	      fact = fact * i;
	    }  
	    num = fact;
	    return num;
	}
	public static long factorialUsingStreams(int n) {
	    return LongStream.rangeClosed(1, n)
	        .reduce(1, (long x, long y) -> x * y);
	}
	
	public static long factorialUsingRecursion(int n) {
	    if (n <= 2) {
	        return n;
	    }
	    return n * factorialUsingRecursion(n - 1);
	}

}
