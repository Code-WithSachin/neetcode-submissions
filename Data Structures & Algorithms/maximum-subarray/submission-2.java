class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentMaxSum = 0;
        for (int j = 0; j < nums.length; j++) {
            currentMaxSum = Math.max(currentMaxSum+=nums[j], nums[j]);
            maxSum = Math.max(maxSum, currentMaxSum);
        }
        
        return maxSum;
    }
}
