class MinStack {

    private Stack<Integer> stack;
    private PriorityQueue<Integer> q;

    public MinStack() {
        stack = new Stack<>();
        q = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        q.add(x);
    }

    public void pop() {
        int p = stack.pop();
        q.remove(p);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return q.peek();
    }
}