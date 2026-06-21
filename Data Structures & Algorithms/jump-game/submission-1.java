class Solution {
    public boolean check(int index, int[] nums){
        if(index >= nums.length-1) return true;

        for(int i = 1; i<= nums[index]; i++){
            if(check(index+i, nums)) return true;
        }

        return false;
    }
    public boolean canJump(int[] nums) {
        return check(0, nums);
    }
}
