/*
https://leetcode.com/problems/reverse-words-in-a-string/
Space Complexity - O(1)
Time Complexity - O(N)

*/
public class Solution {
    public String reverseWords(String s) {
        if(s == null) return "";
        int j = s.length() - 1;
        
        StringBuilder buffer = new StringBuilder();
        
        while(j >= 0) {
            while(j >= 0 && Character.isWhitespace(s.charAt(j))) {j--;}
            int i = j;
            while(i >= 0 && !Character.isWhitespace(s.charAt(i))) {i--;}
            buffer.append(s.substring(i + 1, j + 1));
            buffer.append(" ");
            j = i;
        }
        return buffer.toString().trim();
    }
}
