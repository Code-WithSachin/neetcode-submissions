class Solution {
    public int recur(int index, int[]cost, int[]dp){
        if(index >= cost.length) return 0;
        if(dp[index]!=0) return dp[index];
        
        int oneStep = recur(index+1, cost, dp) + cost[index];
        int twoStep = recur(index+2, cost, dp) + cost[index];
        
        return dp[index] = Math.min(oneStep, twoStep);
        
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        return Math.min(recur(0, cost, dp), recur(1, cost, dp)) ;
        
    }
}