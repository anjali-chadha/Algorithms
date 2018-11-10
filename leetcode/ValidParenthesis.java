class Solution {
    private static HashMap<Character, Character> paraMap = new HashMap<Character, Character>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};
    
    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) return true;
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()) {
            if(paraMap.containsKey(c)) stack.push(c);
            else {
                if(stack.isEmpty() || paraMap.get(stack.pop()) != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
