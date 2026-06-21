class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        int [] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int row[]: times){
            adj.get(row[0]).add(new int[]{row[1], row[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1]-b[1]);
        pq.add(new int[]{k, 0});
        minTime[k] = 0;

        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int node = pair[0];
            int distance = pair[1];

            for(int[] neighbour: adj.get(node)){
                int currNode = neighbour[0];
                int currDistance = distance+neighbour[1];
                if(minTime[currNode] > currDistance){
                    minTime[currNode] = currDistance;
                    pq.add(new int[]{currNode, currDistance});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, minTime[i]);
        }

        return ans;
    }
}
