class Solution {
    public int check(int index, int[] nums, int memo[]){
        if(index >= nums.length-1) return 0;

        if(memo[index] != -1) return memo[index];
        // RULE 1: Landed on a '0' tile? You are stuck. Instant dead end.
        if (nums[index] == 0) return 1000000000;

        // RULE 2: Can your maximum jump clear the board? 
        // If yes, it takes exactly 1 jump to win from here!
        if (index + nums[index] >= nums.length - 1) return 1;

        int min = 1000000000;
        for(int i = nums[index]; i>=1; i--){
            min = Math.min(min, 1+check(index+i, nums, memo));
        }
        return memo[index] = min;
    }
    public int jump(int[] nums) {
        int memo[] = new int [nums.length];
        Arrays.fill(memo, -1);
        return check(0, nums, memo);
    }
}
