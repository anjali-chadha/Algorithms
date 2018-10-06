package leetcode;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int count = 0;
        while(xor != 0) {
            count += (xor & 1);
            xor/= 2;
        }
        return count;
    }
}
