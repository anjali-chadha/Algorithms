package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> candiesSet = new HashSet<>();
        for(int c: candies) candiesSet.add(c);

        int uniqueCandies = candiesSet.size();
        int totalCandies = candies.length;

        return Math.min(uniqueCandies, totalCandies/2);
    }
}
