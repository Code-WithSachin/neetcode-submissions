class Solution {
    public int recur(int index, int[]nums, int[]memo){
        if(index >= nums.length) return 0;

        if(memo[index]!= -1) return memo[index];

        int rob = nums[index]+recur(index+2, nums, memo);

        int notRob = recur(index+1, nums, memo);

        memo[index] = Math.max(rob, notRob);
        return memo[index];
    }
    public int rob(int[] nums) {
        int memo[] = new int[nums.length];
        Arrays.fill(memo, -1);
        return recur(0, nums, memo);
    }
}