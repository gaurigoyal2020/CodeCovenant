class MinStack {

    Stack<Integer> s;
    Stack<Integer> minS;

    public MinStack() {
        s = new Stack<>();
        minS = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(minS.isEmpty() || val <= minS.peek())
            minS.push(val);
    }
    
    public void pop() {
        if(s.peek().equals(minS.peek()))
        minS.pop();
        s.pop();
    }
    
    public int top() {
        return s.isEmpty() ? -1 : s.peek();
    }
    
    public int getMin() {
        return minS.isEmpty() ? -1 : minS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
