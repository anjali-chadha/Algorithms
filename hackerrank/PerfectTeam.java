
    /*
     * Complete the function below.
     */
    static int differentTeams(String skills) {
        if(skills == null || skills.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < skills.length(); i++) {
            char key = skills.charAt(i);
            int val = map.containsKey(key)? map.get(key): 0;
            map.put(key, val + 1);
        }
        
        int minVal = Integer.MAX_VALUE;
        if(map.size() != 5) return 0;
        for(int i: map.values()) {
            if(i < minVal) minVal = i;
        }
        return minVal;
    }
