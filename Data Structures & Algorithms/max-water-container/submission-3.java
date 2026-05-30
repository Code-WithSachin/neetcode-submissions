class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int start = 0, end = n-1, currWater = Integer.MIN_VALUE, maxWater = 0;

        while(start < end){
            currWater = Math.min(heights[start], heights[end]) * (end - start);
            maxWater = Math.max(maxWater, currWater);

            if(heights[start] <= heights[end]){
                start++;
            }else{
                end--;
            }
        }

        return maxWater;
    }
}
