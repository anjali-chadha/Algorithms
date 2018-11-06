/*
Algorithm - sieve of eratosthenes
Time Complexity - O(N log log N)
*/
class Solution {
    public int countPrimes(int n) {
        if(n < 3) return 0;
        boolean[] notPrime = new boolean[n];
        int primeCount = 0;
        
        for(int i = 2; i < n; i ++){
            if(!notPrime[i]) {
                primeCount++;
            
                for(int j = 2*i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        return primeCount;
    }
}
