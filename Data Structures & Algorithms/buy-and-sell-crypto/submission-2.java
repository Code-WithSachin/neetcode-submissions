class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> st = new Stack<>();

        int ans = 0;
        for(int price: prices){
            if(!st.isEmpty() && price > st.peek()){
                ans = Math.max(ans, price-st.peek());
            }else{
                st.push(price);
            }
        }

        return ans;
    }
}
