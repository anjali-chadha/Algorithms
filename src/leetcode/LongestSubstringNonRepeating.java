package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNonRepeating {
        public int lengthOfLongestSubstring(String s) {
            return windowSolution(s);
        }

        private int windowSolution(String s) {
            int maxLength = 0;
            int n = s.length();
            int i = 0;
            int j = 1;
            Set<Character> characterSet = new HashSet<>();

            while(j > i && j <= n) {
                if(characterSet.contains(s.charAt(j - 1))) {
                    characterSet.remove(s.charAt(i));
                    i ++;
                } else {
                    characterSet.add(s.charAt(j - 1 ));
                    maxLength = Math.max(maxLength, j - i);
                    j++;
                }
            }
            return maxLength;
        }


        private int naiveSolution(String s) {
            int len = s.length();

            int maxLength = 0;
            for(int i = 0; i < len; i++) {
                for(int j = i + 1; j <= len; j++) {
                    if(hasUniqueCharacters(s, i, j)) {
                        maxLength = Math.max(maxLength, j-i);
                    }
                }
            }
            return maxLength;
        }

        private boolean hasUniqueCharacters(String s, int start, int end) {
            Set<Character> characterSet = new HashSet<>();
            int n = s.length();
            for(int i = start; i < end; i++) {
                if(characterSet.contains(s.charAt(i))) {
                    return false;
                }
                characterSet.add(s.charAt(i));
            }
            return true;
        }

}
