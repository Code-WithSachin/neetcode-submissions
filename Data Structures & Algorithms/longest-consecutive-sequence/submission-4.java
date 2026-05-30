class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return nums.length;

        Arrays.sort(nums);

        int count = 0, lastMin = Integer.MIN_VALUE, ans = 0;

        for(int num: nums){
            if(num == lastMin+1){
                count++;
            }else if(num != lastMin){
                count = 1;
            }

            lastMin = num;
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
