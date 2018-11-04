/*
Two pass solution:
First Pass - Count the frequency of characters
SEcond Pass - REturn the character with frequency 1
Space and Time - O(N)
*/

class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.isEmpty()) return -1;
        
        int[] countArray = new int[26];
 
        for(char c: s.toCharArray()) {
            countArray[c-'a']++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(countArray[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
