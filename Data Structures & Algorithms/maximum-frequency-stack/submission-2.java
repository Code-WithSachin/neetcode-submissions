class FreqStack {
    HashMap<Integer, Integer> freqMap;
    HashMap<Integer, Stack<Integer>> mapOfStacks;
    int maxFreq;
    public FreqStack() {
        freqMap = new HashMap<>();
        mapOfStacks = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0)+1);
        int currFreq = freqMap.get(val);
        Stack<Integer> st;
        if(mapOfStacks.containsKey(currFreq)){
            st = mapOfStacks.get(currFreq);
        }else{
            st = new Stack();
        }
        st.push(val);
        mapOfStacks.put(currFreq, st);

        if(currFreq > maxFreq) maxFreq = currFreq;
    }
    
    public int pop() {
        Stack<Integer> st = mapOfStacks.get(maxFreq);
        int ele = st.pop();
        freqMap.put(ele, freqMap.get(ele)-1);
        if(st.isEmpty()) maxFreq--;
        return ele;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */