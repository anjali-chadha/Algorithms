/**
* Approach 1: Time compleity O(size of integer)
* Pitfall - For unsigned integer, use  >>> unsigned right shift operator.
* 
* Approach 2 - Uses the fact that
* (x&x-1) removes the right most 1 for x.
**/

public class Solution {
    
    // you need to treat n as an unsigned value
    //Approach 1
    public int hammingWeight(int n) {
        if(n == 0) return 0;
        int res = 0;
        while(n != 0) {
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }
    
    //Approach 2
    public int hammingWeight_2(int n) {
        int res = 0;
        while(n != 0) {
            n = n & (n-1);
            res++;
        }
        return res;
    }
}
