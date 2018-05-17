/* 
InterviewBit: NUM1BITS
Write a function that takes an unsigned integer and returns the number of 1 bits it has.
Note that since Java does not have unsigned int, use long for Java
*/

public class Solution {
	
  //Naive Solution - Iterating all 32 bits
  public int numSetBits_v1(long a) {
	    long maxAllowed = (long) Math.pow(2, 32) - 1;
	    if(a <= 0 || a > maxAllowed) {
	        return 0;
	    }
	    
	    int count = 0;
	    while(a != 0) {
	        if((a & 1) != 0) {
	            count ++;
	        }
	        a = a>>1;
	    }
	    return count;
	}
  
  // Better Solution
  public int numSetBits_v2(long a) {
    long maxAllowed = (long) Math.pow(2, 32) - 1;
    if(a <= 0 || a > maxAllowed) {
        return 0;
    }

    int count = 0;
    while( a != 0) {
        count++;
        a = (a & (a-1));
    }
    return count;
}
}
