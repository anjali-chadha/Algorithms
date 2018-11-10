/*
Algorithm:
Using Stack

Below code is a clean version. If a new Operator is added, we need to do changes in only one place in the code

*/

class Solution {
    
    interface Operator {
        int eval(int x, int y);
    }
    
    private static HashMap<String, Operator> charOperationMap = 
        new HashMap<>();
    
    private static void initializeOperators() {
        charOperationMap.put("+", (a, b) -> (a+b));
        charOperationMap.put("-", (a, b) -> (a-b));
        charOperationMap.put("*", (a, b) -> (a*b));
        charOperationMap.put("/", (a, b) -> (a/b));
    }
    
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        initializeOperators(); 
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s: tokens) {
            if(charOperationMap.containsKey(s)) {
                int y = stack.pop();
                int x = stack.pop();
                int operatorResult = charOperationMap.get(s).eval(x, y);
                stack.push(operatorResult);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
