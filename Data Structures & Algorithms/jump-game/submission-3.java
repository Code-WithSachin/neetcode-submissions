class Solution {
    public boolean check(int index, int[] nums, int memo[]){
        if(index >= nums.length-1) return true;

        if(memo[index] != -1) return memo[index]==1;

        for(int i = 1; i<= nums[index]; i++){
            if(check(index+i, nums, memo)) {
                memo[index] = 1;
                return true;
            }
        }
        memo[index] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int memo[] = new int[nums.length];
        Arrays.fill(memo, -1);
        return check(0, nums, memo);
    }
}
