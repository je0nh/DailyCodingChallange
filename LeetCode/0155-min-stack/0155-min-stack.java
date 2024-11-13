class MinStack {
    private List<Integer> ms;

    public MinStack() {
        ms = new ArrayList<>();
    }
    
    public void push(int val) {
        ms.add(val);
    }
    
    public void pop() {
        if (ms.size() != 0) {
            ms.remove(ms.size() - 1);
        }
    }
    
    public int top() {
        return ms.get(ms.size() - 1);
    }
    
    public int getMin() {
        return Collections.min(ms);
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