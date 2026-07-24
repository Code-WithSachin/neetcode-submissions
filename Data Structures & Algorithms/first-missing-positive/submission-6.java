class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i =0; i<n; i++){
            if(nums[i]-1 >= 0){
            int correctIndex = nums[i]-1;
            while(nums[i] >= 1 && nums[i] <= n && nums[i] != nums[correctIndex]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

                correctIndex = nums[i]-1;
            }
            }
        }

        for(int i = 0; i<n; i++){
            if(i+1 != nums[i]) return i+1;
        }
        
        return n + 1;
    }
}