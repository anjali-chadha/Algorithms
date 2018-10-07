/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 Test Cases
 1) Input: [1, 2, 3] output: 4, because you will pick 1 and 3
2) input: [5,1, 2, 6] output: 11, because you will pick 5 and 6
3) input: [5,1, 2, 6, 20, 2] output: 27, because you will pick 5, 2, 20  
4) input: [5, 1, 1, 5] output: 10
5) input: [4,9,6] output 10
6) input: [4,10,3,1,5] output 15
/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static int accomodateMaxNights(int[] rates) {
		if(rates == null || rates.length == 0) return 0;
		int prev1=0;
		int prev2=0;
		for(int e: rates) {
			int todaySale = e + prev2;
			int todayNoSale = Math.max(prev1, prev2);
			prev1 = todaySale;
			prev2 = todayNoSale;
		}
		return Math.max(prev1, prev2);
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(accomodateMaxNights(new int[]{1,2,3}));
		System.out.println(accomodateMaxNights(new int[]{5,1,2,6}));
		System.out.println(accomodateMaxNights(new int[]{5,1,2,6,20,2}));
		System.out.println(accomodateMaxNights(new int[]{5,1,1,5}));
		System.out.println(accomodateMaxNights(new int[]{4,9,6}));
		System.out.println(accomodateMaxNights(new int[]{4,10,3,1,5}));
	}
}
