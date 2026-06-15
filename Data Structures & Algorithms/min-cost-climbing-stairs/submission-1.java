class Solution {
    public int recur(int index, int[]cost, int[]memo){
        if(index == cost.length) return 0;
        if(index == cost.length-1) return cost[index];

        if(memo[index]!= -1) return memo[index];

        int oneStep = cost[index]+recur(index+1, cost, memo);
        int twoSteps=Integer.MAX_VALUE;
        if(index+2 <= cost.length){
            twoSteps = cost[index]+recur(index+2, cost, memo);
        }

        memo[index] = Math.min(oneStep, twoSteps);
        return memo[index];
    }
    public int minCostClimbingStairs(int[] cost) {
        int memo[] = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(recur(0, cost, memo), recur(1, cost, memo));
    }
}
