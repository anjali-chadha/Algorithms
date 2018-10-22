//https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.NavigableMap;
class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return "";
        
        Map<Character, Integer> characterCount = new HashMap();
        for(char c: s.toCharArray()) {
            int old = characterCount.getOrDefault(c, 0);
            characterCount.put(c, old + 1);
        }
        
        NavigableMap<Integer, Set<Character>> heap = new TreeMap<>();
        for(Map.Entry<Character, Integer> e: characterCount.entrySet()) {
            char c = e.getKey();
            int count = e.getValue();
            
            Set set = heap.get(count);
            if(set == null) {
                set = new HashSet<String> ();
                heap.put(count, set);
            }
            set.add(c);
        }
        
        StringBuilder result = new StringBuilder();
        for(Map.Entry<Integer, Set<Character>> e: heap.entrySet()) {
            int count = e.getKey();
            Set<Character> cSet = e.getValue();
            for(Character c: cSet) {
                for(int i = 0; i < count; i++) {
                    result.insert(0, c);
                }
            }
        }
        return result.toString();
    }
}
