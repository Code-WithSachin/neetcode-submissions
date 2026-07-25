class Solution {
    public void rotateHelper(int left, int right, int[]nums){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        rotateHelper(0, nums.length-1, nums);
        rotateHelper(0, k-1, nums);
        rotateHelper(k, nums.length-1, nums);
    }
}