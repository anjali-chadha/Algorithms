/*
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
NOTE A solution will always exist. read Goldbach’s conjecture
*/

public class Solution {
    
    public ArrayList<Integer> primesum_v1(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if(A <= 2 || A%2 != 0){
            // Do nothing
        } else if(A == 4) {
            result.add(2);
            result.add(2);
        } else {
           //Assuming that the pair of prime numbers will always be odd except for number 4 (handled as a separate case above)
           for(int i = 3; i <= A/2; i+=2) {
                int p = i;
                int q = A - p;
                
                if(isPrime(p) && isPrime(q)) {
                    result.add(Math.min(p, q));
                    result.add(Math.max(p,q));
                    break;
                }
            }
        }
        return result;
    }
    
    //Checks if a number is prime or not
    private boolean isPrime(int n) {
        if(n == 2) return true;
        if(n <= 1 || n%2 == 0) return false;
        
        for(int i = 3; i <= n/2; i += 2) {
            if(n%i == 0) return false;
        }
        return true;
    }
}
