package leetcode;

import java.util.HashSet;
import java.util.Set;

public class JewelsStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet();;
        for(char c: J.toCharArray()) jewels.add(c);

        int count = 0;
        for(char s: S.toCharArray()) {
            if(jewels.contains(s)) count++;
        }
        return count;
    }
}
