class Solution {
    public int check(int index, int target, int[] nums){
        if(index == nums.length && target == 0) return 1;

        if(index == nums.length) return 0;

        int positive = check(index+1, target-nums[index], nums);
        int negative = check(index+1, target-(nums[index]*-1), nums);

        return positive+negative;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return check(0, target, nums);
    }
}
