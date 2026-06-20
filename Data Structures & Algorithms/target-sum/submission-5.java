class Solution {
    public int check(int index, int target, int[] nums, int[][] memo, int sum){
        if(index == nums.length && target == 0) return 1;
        if(index == nums.length) return 0;

        int shiftCol = target+sum;
        if(shiftCol < 0 || shiftCol >= memo[0].length) return 0;

        if(memo[index][shiftCol] != -1) return memo[index][shiftCol];

        int positive = check(index+1, target-nums[index], nums, memo, sum);
        int negative = check(index+1, target-(nums[index]*-1), nums, memo, sum);

        int total = positive+negative;
        return memo[index][shiftCol] = total;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0; 
        for(int num: nums){
            sum+=num;
        }
        int[][] memo = new int[nums.length][sum*2+1];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return check(0, target, nums, memo, sum);
    }
}
