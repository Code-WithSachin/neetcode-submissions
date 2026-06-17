class Solution {
    public int coinChangeHelper(int index, int amount, int[]coins, int memo[][]){
        if(amount == 0) return 1;
        if(index == coins.length || amount < 0) return 0;

        if(memo[index][amount] != -1) {
            return memo[index][amount];
        }
        
        int take = coinChangeHelper(index, amount-coins[index], coins, memo);
        int notTake = coinChangeHelper(index+1, amount, coins, memo);

        return memo[index][amount] = take+notTake;
    }
    public int change(int amount, int[] coins) {
        int memo[][] = new int[coins.length][amount+1];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return coinChangeHelper(0, amount, coins, memo);
        // return ans >= 1000000000 ? -1 : ans;
    }
}
