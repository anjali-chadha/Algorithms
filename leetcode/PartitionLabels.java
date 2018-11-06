/**
* https://leetcode.com/problems/partition-labels/
* Algorithm: Time/space Complexity O(N)
* Greedy Optimisation - When you make a decision, you never change it.
*
* Two-Pass Algorithm -
* 1) Store the last indices of each chanracter appearing in the string
* 2) Update the end pointer of a substring using the above map
**/

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S == null || S.length() == 0) return result;
        
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            lastIndexMap.put(c, i);
        }
        int L = 0, R = 0;
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            R = Math.max(lastIndexMap.get(c), R);
            if(R == i) {
                result.add(R+1-L);
                L = R + 1;
            }
        }
        return result;
    }
}
