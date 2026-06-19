class Solution {
    public boolean canPartitionHelper(int index, int target, int[]nums, Boolean[][] memo){
        if(target == 0) return true;
        if(target < 0 || index == nums.length) return false;

        if(memo[index][target] != null) return memo[index][target];

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
        Boolean memo[][] = new Boolean[nums.length][target+1];
        return canPartitionHelper(0, target, nums, memo);
    }
}
