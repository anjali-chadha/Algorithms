package leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern1 {

    // This one just uses one data structure as compared to the two in the 
    // below approach.
    public boolean wordPatternBetterApproach(String pattern, String str) {
        char[] patternArr = pattern.toCharArray();
        String[] strArr = str.split(" ");
        
        int m = patternArr.length;
        int n = strArr.length;
        
        if(m != n) return false;
        
        Map<String, Character> patternMap = new HashMap<>();
        
        for(int i = 0; i < m; i ++) {
            String key = strArr[i];
            Character value = patternArr[i];
            
            if(patternMap.containsKey(key) ^ patternMap.containsValue(value)) {
                return false;
            }
            
            Character oldValue = patternMap.put(key, value);
            if(oldValue != null && oldValue != value) {
                return false;
            }
            
        }
        return true;
    }
    
    public boolean wordPattern(String pattern, String str) {
        char[] patternArr = pattern.toCharArray();
        String[] strArr = str.split(" ");
        
        int m = patternArr.length;
        int n = strArr.length;
        
        if(m != n) return false;
        
        Set<Character> patternSet = new HashSet<>();
        Map<String, Character> patternMap = new HashMap<>();
        
        for(int i = 0; i < m; i ++) {
            String key = strArr[i];
            Character value = patternArr[i];
            
            if(patternMap.containsKey(key)){
                Character v = patternMap.get(key);
                if(v != value) {return false;}
            } else if(patternSet.contains(value)){
                return false;
            }else {
                patternMap.put(key, value);
                patternSet.add(value);
            }
        }
        return true;
    }
}
