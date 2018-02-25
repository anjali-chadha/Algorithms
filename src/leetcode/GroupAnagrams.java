package leetcode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if(strs == null || strs.length == 0) return result;

        Map<String, List<String>> sortedStringMapping = new HashMap<>();
        for(String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String key = String.valueOf(arr);
            String val = s;
            if(sortedStringMapping.containsKey(key)) {
                sortedStringMapping.get(key).add(val);
            } else {
                List<String> list = new ArrayList<>();
                list.add(val);
                sortedStringMapping.put(key, list);
            }
        }

        for(List<String> value: sortedStringMapping.values()) {
            result.add(value);
        }
        return result;

    }
}
