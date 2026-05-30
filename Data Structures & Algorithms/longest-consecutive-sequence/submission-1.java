class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 2) return nums.length;

        Arrays.sort(nums);

        int count = 0, lastMin = Integer.MIN_VALUE, ans = 0;

        for(int num: nums){
            if(num == lastMin+1){
                count++;
                lastMin++;
            }else if(num != lastMin){
                lastMin = num;
                count = 1;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
