package leetcode;

public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int zeros = 0;
        while(n > 0) {
            zeros += n/5;
            n = n/5;
        }
        return zeros;
    }
}
