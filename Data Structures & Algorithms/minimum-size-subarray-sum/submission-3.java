class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, ans = Integer.MAX_VALUE, sum = 0;

        for(j = 0; j<nums.length; j++){
            sum+=nums[j];
            while(sum >= target){
                ans = Math.min(ans, j-i+1);
                sum-=nums[i];
                i++;
            } 
        }
        // ans = Math.min(ans, j-i+1);
        return ans != Integer.MAX_VALUE ? ans : 0;
    }
}