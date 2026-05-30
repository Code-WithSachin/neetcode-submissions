class Solution {
    public int trap(int[] height) {
        int n = height.length, ans = 0;
        int [] prefMax = new int[n];
        int [] suffMax = new int[n];

        int leftMax= 0;
        for(int i = 0; i<n; i++){
            leftMax = Math.max(leftMax, height[i]);
            prefMax[i] = leftMax;
        }

        int rightMax = 0;
        for(int i = n-1; i>=0; i--){
            rightMax = Math.max(rightMax, height[i]);
            suffMax[i] = rightMax;
        }
        
        for(int i = 0; i<n; i++){
            ans+=Math.min(prefMax[i], suffMax[i]) - height[i];
        }
        return ans;
    }
}
