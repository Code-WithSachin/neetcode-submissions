class Solution {
    public static double distanceFromOrigin(int[] point) {
        double x = point[0];
        double y = point[1];
        return Math.sqrt((x * x) + (y * y));
    }
    public int[][] kClosest(int[][] points, int k) {
        Queue<List<Double>> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.get(0), a.get(0)));

        for(int point[]: points){
            double distance = distanceFromOrigin(point);
            List<Double> list = Arrays.asList(distance, (double) point[0], (double) point[1]);
            maxHeap.add(list);

            if(maxHeap.size() > k) maxHeap.poll();
        }

        int ans[][] = new int[k][2];
        int pointer = 0;
        while(!maxHeap.isEmpty()){
           List<Double> currList = maxHeap.poll();
    
            int[] curr = new int[2];
            curr[0] = currList.get(1).intValue(); // X coordinate
            curr[1] = currList.get(2).intValue(); // Y coordinate (Fixed index from 2 to 1)

            ans[pointer++] = curr;     // Fixed assignment syntax
        }

        return ans;
    }
}
