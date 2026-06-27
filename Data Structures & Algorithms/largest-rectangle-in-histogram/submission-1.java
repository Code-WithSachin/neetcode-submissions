class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int nextSmallerEles[] = new int[n];
        Arrays.fill(nextSmallerEles, n);

        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                nextSmallerEles[st.pop()] = i;
            }
            st.push(i);
        }

        int prevSmallerEles[] = new int[n];
        Arrays.fill(prevSmallerEles, -1);
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                prevSmallerEles[st.pop()] = i;
            }
            st.push(i);
        }

        int maxArea = 0;
        for(int i = 0; i<n; i++){
            maxArea = Math.max(maxArea, (heights[i]*(nextSmallerEles[i]-prevSmallerEles[i]-1)));
        }
        return maxArea;
    }
}
