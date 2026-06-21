class Solution {
    public boolean canJumpFrom(int index, int[] nums) {
        // Base Case: We reached or passed the last index!
        if (index >= nums.length - 1) return true;

        int maxJump = nums[index];
        
        // Try every single possible jump length from 1 up to maxJump
        for (int i = 1; i <= maxJump; i++) {
            // If ANY jump path leads to victory, exit early with true!
            if (canJumpFrom(index + i, nums)) {
                return true; 
            }
        }

        // If no jumps from this position work, it's a dead end
        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFrom(0, nums);
    }
}