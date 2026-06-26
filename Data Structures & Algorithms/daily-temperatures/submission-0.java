class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[]ans = new int[temperatures.length];
        int j = 0;

        for(int i =0; i<temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                ans[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
        }

        return ans;
    }
}
