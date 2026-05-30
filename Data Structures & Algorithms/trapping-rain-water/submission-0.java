class Solution {
    public int trap(int[] height) {
        int n = height.length, ans = 0;

        for(int i = 0; i<n; i++){
            int leftMax = -1;
            int rightMax = -1;

            for(int j = 0; j<i; j++){
                leftMax = Math.max(leftMax, height[j]);
            }
            for(int j = i; j<n; j++){
                rightMax = Math.max(rightMax, height[j]);
            }

            if(leftMax <= height[i] || rightMax <= height[i]) ans+=0;
            else{
                ans = ans + Math.min(leftMax, rightMax)-height[i];
            }
        }

        return ans;
    }
}
