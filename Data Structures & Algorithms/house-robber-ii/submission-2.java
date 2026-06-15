class Solution {
    public int recur(int startIndex, int endIndex, int[] nums, int[] memo){
        // Base case: if we reach or exceed our exclusive boundary, stop.
        if (startIndex >= endIndex) return 0;

        if (memo[startIndex] != -1) return memo[startIndex];

        // Take / Not Take logic (perfectly preserved!)
        int rob = nums[startIndex] + recur(startIndex + 2, endIndex, nums, memo);
        int notRob = recur(startIndex + 1, endIndex, nums, memo);

        memo[startIndex] = Math.max(rob, notRob);
        return memo[startIndex];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        
        // Edge case: If there's only 1 house, just rob it!
        if (n == 1) return nums[0];
        
        int memo[] = new int[n];
        
        // Scenario 1: Rob from house 0 up to (but excluding) the last house (n-1)
        Arrays.fill(memo, -1);
        int ans1 = recur(0, n - 1, nums, memo);
        
        // Scenario 2: Rob from house 1 up to (and including) the last house (n)
        Arrays.fill(memo, -1);
        int ans2 = recur(1, n, nums, memo);
        
        return Math.max(ans1, ans2);
    }
}