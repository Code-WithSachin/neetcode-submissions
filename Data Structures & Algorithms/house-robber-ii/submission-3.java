class Solution {
    public int recur(int startIndex, int endIndex, int[] nums, int[] memo) {
        // EXCLUSIVE BASE CASE: 
        // If we reach or pass the boundary, we are out of bounds. Return 0.
        if (startIndex >= endIndex) return 0;

        // Memoization Check
        if (memo[startIndex] != -1) return memo[startIndex];

        // "Take / Not Take" choices
        int rob = nums[startIndex] + recur(startIndex + 2, endIndex, nums, memo);
        int notRob = recur(startIndex + 1, endIndex, nums, memo);

        // Record and return
        memo[startIndex] = Math.max(rob, notRob);
        return memo[startIndex];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        
        // Edge case guard for a single house
        if (n == 1) return nums[0];
        
        int memo[] = new int[n];
        
        // Scenario 1: Skip Last House (Window: 0 to n-1)
        Arrays.fill(memo, -1);
        int ans1 = recur(0, n - 1, nums, memo);
        
        // Scenario 2: Skip First House (Window: 1 to n)
        Arrays.fill(memo, -1);
        int ans2 = recur(1, n, nums, memo);
        
        // Return the maximum profit between the two scenarios
        return Math.max(ans1, ans2);
    }
}