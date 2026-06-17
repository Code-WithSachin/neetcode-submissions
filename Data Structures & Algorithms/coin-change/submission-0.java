class Solution {
    public int coinChangeHelper(int index, int amount, int[]coins){
        if(amount == 0) return 0;

        int take = 1000000000, notTake = 1000000000;
        if(index < coins.length && coins[index] <= amount){
            take = 1+coinChangeHelper(index, amount-coins[index], coins);
        }
        if(index+1 < coins.length){
            notTake = coinChangeHelper(index+1, amount, coins);
        }

        return Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int ans = coinChangeHelper(0, amount, coins);
        return ans >= 1000000000 ? -1 : ans;
    }
}
