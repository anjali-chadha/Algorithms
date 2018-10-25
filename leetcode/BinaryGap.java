//https://leetcode.com/problems/binary-gap/
class Solution {
    public int binaryGap(int N) {
       if(N <= 2) return 0;
        String binaryRep = Integer.toBinaryString(N);
        return longestGap(binaryRep);
    }
    
    private int longestGap(String s) {
        char[] A = s.toCharArray();
        int maxGap = 0;
        int last1Seen = s.indexOf('1');
        for(int i = last1Seen + 1; i < s.length(); i++) {
            if(A[i] == '1') {
                int gap = i - last1Seen;
                if(gap > maxGap) maxGap = gap;
                last1Seen = i;   
            }
        }
        return maxGap;
    }
}
