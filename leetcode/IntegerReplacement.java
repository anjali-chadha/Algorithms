class Solution {
    public int integerReplacement(int n) {
        if(n <= 1) return 0;
        if(n%2 == 0) return 1 + integerReplacement(n/2);
        //Handle Integer Overflow case
        else return 1 + Math.min(integerReplacement(n/2+1)+1, integerReplacement(n-1));
    }
}
