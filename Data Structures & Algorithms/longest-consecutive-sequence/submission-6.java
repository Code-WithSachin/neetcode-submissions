class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return nums.length;

        HashSet<Integer> set = new HashSet<>();

        int ans = 0, count = 0;

        for(int num: nums){
            set.add(num);
        }

        for(int num: set){
            if(!set.contains(num-1)){
                int currNum = num;
                count = 0;
                while(set.contains(currNum)){
                    count++; 
                    currNum++;
                }
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
