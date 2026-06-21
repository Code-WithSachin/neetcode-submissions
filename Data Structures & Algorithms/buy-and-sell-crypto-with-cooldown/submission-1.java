class Solution {
    public int checkProfit(int index, int canBuy, int[] prices, int memo[][]){
        if(index >= prices.length) return 0;

        if(memo[index][canBuy] != -1) return memo[index][canBuy];

        int profit = 0;
        if(canBuy == 1){
            int buy = -prices[index]+checkProfit(index+1, 0, prices, memo);
            int notBuy = 0+checkProfit(index+1, 1, prices, memo);
            profit = Math.max(buy, notBuy);
        }else{
            int sell = prices[index]+checkProfit(index+2, 1, prices, memo);
            int notSell = 0+checkProfit(index+1, 0, prices, memo);
            profit = Math.max(sell, notSell);
        }

        return memo[index][canBuy] = profit;
    }
    public int maxProfit(int[] prices) {
        int memo[][] = new int[prices.length][2]; 
        for(int row[] : memo){
            Arrays.fill(row, -1);
        }
        return checkProfit(0, 1, prices, memo);
    }
}
