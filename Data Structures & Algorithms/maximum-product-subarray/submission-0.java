class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        // Outer loop picks the starting element of the subarray
        for (int i = 0; i < nums.length; i++) {
            int currentProduct = 1;
            
            // Inner loop expands the subarray to the right
            for (int j = i; j < nums.length; j++) {
                currentProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
        }
        
        return maxProduct;
    }
}
