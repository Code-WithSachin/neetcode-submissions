class Solution {
    public int lisHelper(int index, int prevIndex, int[] nums, int memo[][]) {
        if (index == nums.length) return 0;

        if(memo[index][prevIndex+1] != -1) return memo[index][prevIndex+1];

        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + lisHelper(index + 1, index, nums, memo);
        }

        int notTake = lisHelper(index + 1, prevIndex, nums, memo);

        return memo[index][prevIndex+1] = Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int memo[][] = new int[n][n+1];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return lisHelper(0, -1, nums, memo);
    }
}