/**
Time and space Trade off
Extra space used - O(N)
Time complexity - O(1) for all operations
*/

class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x) minStack.push(x);
    }
    
    public void pop() {
        if(stack.pop().equals(minStack.peek())) minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
