class StockSpanner {
    Stack<Integer> st;
    Stack<Integer> helperStack;
    public StockSpanner() {
        st = new Stack<>();
        helperStack = new Stack<>();
    }
    
    public int next(int price) {        
        int ans = 0;
        while(!st.isEmpty() && st.peek() <= price){
            helperStack.push(st.pop());
        }

        ans = helperStack.size()+1;

        while(!helperStack.isEmpty() ){
            st.push(helperStack.pop());
        }
        st.push(price);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */