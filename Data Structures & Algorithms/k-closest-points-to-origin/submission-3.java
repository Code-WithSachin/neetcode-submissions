class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-Heap storing double[] arrays: [actual_distance, x, y]
        // Must use Double.compare because subtraction doesn't work for doubles here
        Queue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] point : points) {
            double x = point[0];
            double y = point[1];
            
            // Calculating the literal square root distance
            double actualDistance = Math.sqrt((x * x) + (y * y)); 

            // Pack it into a double array: [distance, x, y]
            maxHeap.offer(new double[]{actualDistance, x, y});

            // Keep heap size restricted to K
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Build the final result array
        int[][] ans = new int[k][2];
        int pointer = 0;
        
        while (!maxHeap.isEmpty()) {
            double[] curr = maxHeap.poll();
            
            // Cast the coordinates back to int since ans[][] expects integers
            ans[pointer++] = new int[]{(int) curr[1], (int) curr[2]};
        }

        return ans;
    }
}