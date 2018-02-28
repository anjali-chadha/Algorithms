package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
        public boolean wordBreak(String s, List<String> wordDict) {
            if(s == null || wordDict == null) return false;

            if(s.isEmpty()) return true;

            Set<String> dict = new HashSet<>(wordDict);

            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;

            for(int i = 1; i <= n; i++) {
                for(int j = 0; j < i; j ++) {
                    if(dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }
            return dp[n];
        }
}
