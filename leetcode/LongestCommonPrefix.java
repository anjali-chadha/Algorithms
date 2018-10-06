class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Error Handling
        if(strs == null || strs.length == 0) {
            return "";
        }
        
        int n = strs.length;
        
       //Main Algorithm
        String commonPrefix = strs[0];
        for(int i = 1; i < n; i++) {
            int idx = findMatchingIndexes(commonPrefix, strs[i]);
            if(idx == -1) return "";
            commonPrefix = commonPrefix.substring(0, idx + 1);
        }
        return commonPrefix;
    }
    
    private int findMatchingIndexes(String prefix, String s) {
        int m = prefix.length();
        int n = s.length();
        
        int idx = -1;
        for(int i = 0; i < m && i < n; i++) {
            if(prefix.charAt(i) == s.charAt(i)) {
                idx = i;
            } else {
                return idx;
            }
        }
        return idx;
    }
}
