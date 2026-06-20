class Solution {
    public int check(int index, int target, int[] nums, HashMap<String, Integer> memo){
        if(index == nums.length && target == 0) return 1;
        if(index == nums.length) return 0;

        String key = index+","+target;
        if(memo.containsKey(key)) return memo.get(key);

        int positive = check(index+1, target-nums[index], nums, memo);
        int negative = check(index+1, target-(nums[index]*-1), nums, memo);

        int total = positive+negative;
        memo.put(key, positive+negative);
        return total;
    }
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> memo = new HashMap<>();
        return check(0, target, nums, memo);
    }
}
