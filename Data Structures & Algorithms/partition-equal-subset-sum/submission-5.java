class Solution {
    public boolean canPartitionHelper(int index, int target, int[] nums, int[][] memo){
        // 1. Absolute Base Cases
        if (target == 0) return true; 
        if (target < 0 || index == nums.length) return false;

        // 2. THE CHECK: 0 means we haven't computed this state yet
        // 1 means FALSE, 2 means TRUE
        if (memo[index][target] != 0) {
            return memo[index][target] == 2; // Returns true if it equals 2, false if it equals 1
        }

        // Choice 1: TAKE
        boolean take = canPartitionHelper(index + 1, target - nums[index], nums, memo);
        if (take) {
            memo[index][target] = 2; // Record TRUE
            return true;
        }
        
        // Choice 2: NOT TAKE
        boolean notTake = canPartitionHelper(index + 1, target, nums, memo);
        
        // 3. THE RECORD: Save 2 for true, 1 for false
        memo[index][target] = (take || notTake) ? 2 : 1;
        return take || notTake;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;
        int target = sum / 2;
        
        // Automatically initialized to 0 (Unvisited) across the board!
        int[][] memo = new int[nums.length][target + 1];
        
        return canPartitionHelper(0, target, nums, memo);
    }
}