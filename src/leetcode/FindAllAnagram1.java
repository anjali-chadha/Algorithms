package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p == null || s == null || p.length() == 0 || s.length() == 0) {
            return new ArrayList<>();
        }

        int patternLength = p.length();
        int textLength = s.length();

        char[] pattern = p.toCharArray();

        List<Integer> result = new ArrayList<>();

        for(int i = 0, j = patternLength; j <= textLength; i++, j++) {
            String text = s.substring(i, j);
            if(isAnagram(text.toCharArray(), pattern)) {
                result.add(i);
            }
        }
        return result;
    }

    //
    private boolean isAnagram(char[] a, char[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}