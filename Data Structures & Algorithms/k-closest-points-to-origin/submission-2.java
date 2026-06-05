class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-Heap: Compare based on index 0 (the squared distance)
        // (a, b) -> b[0] - a[0] puts the largest distance at the top
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            // No Math.sqrt() needed! (x^2 + y^2) is perfectly fine for comparisons
            int squaredDistance = (x * x) + (y * y); 

            // Pack it into a temporary array: [distance, x, y]
            maxHeap.offer(new int[]{squaredDistance, x, y});

            // Keep the heap size restricted to K
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Build the final result array
        int[][] ans = new int[k][2];
        int pointer = 0;
        
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            // curr[1] is x, curr[2] is y
            ans[pointer++] = new int[]{curr[1], curr[2]};
        }

        return ans;
    }
}