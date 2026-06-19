class Solution {
    public int maxSubArray(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int currentProduct = 0;
        for (int j = 0; j < nums.length; j++) {
            currentProduct = Math.max(currentProduct+=nums[j], nums[j]);
            maxProduct = Math.max(maxProduct, currentProduct);
        }
        
        return maxProduct;
    }
}
