class Solution {
    public boolean canPartitionHelper(int index, int target, int[]nums, boolean[][] memo){
        if(target < 0 || index == nums.length) return false;
        if(target == 0) return true;

        if(memo[index][target] != false) return memo[index][target];

        boolean take = canPartitionHelper(index+1, target-nums[index], nums, memo);
        if(take == true) return true;
        boolean notTake = canPartitionHelper(index+1, target, nums, memo);
        
        return memo[index][target] = take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num: nums){
            sum+=num;
        }

        if(sum%2 != 0) return false;

        int target = sum/2;
        boolean memo[][] = new boolean[nums.length][target+1];
        return canPartitionHelper(0, target, nums, memo);
    }
}
