class WordPattern1 {
    
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
