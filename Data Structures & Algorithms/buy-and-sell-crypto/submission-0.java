class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int profit = 0;
        for(int price: prices){
            if(!st.isEmpty() && price > st.peek()){
                profit = Math.max(profit, price-st.peek());
            }
            if(st.isEmpty() || price < st.peek()) st.add(price);
        }

        return profit;
    }
}
