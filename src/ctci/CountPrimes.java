/*
Count the number of prime numbers less than a non-negative number, n.

Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/

class Solution {
    public int countPrimes(int n) {
        //Corner Cases
        if(n <= 1) return 0;
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            for(int j = 2*i; j < n ; j+=i) {
                isPrime[j] = false;
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++)
            if(isPrime[i]) count++;
        
        return count;
    }
}
