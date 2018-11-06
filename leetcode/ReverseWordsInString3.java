/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/
Time Complexity - O(N)
Space complexity - O(N) using an extra array. 
More complicated problem is to solve this question without using extra memory.
*/

class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder("");
        for(String w: words) {
            result.append(reverseWord(w)).append(" ");
        }
        result.deleteCharAt(result.length() -1);
        return result.toString();
    }
    
    private String reverseWord(String word) {
        char[] A = word.toCharArray();
        int i = 0, j = A.length-1;
        while(i < j) {
            char tmp = A[i];
            A[i++] = A[j];
            A[j--] = tmp;
        }
        return new String(A);
    }
}
