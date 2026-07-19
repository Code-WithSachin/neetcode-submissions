class Solution {
    class Pair{
        int distance;
        int node;

        public Pair(int distance, int node){
            this.distance = distance;
            this.node = node;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.distance - b.distance);
        pq.add(new Pair(0, 0));
        boolean[] visited = new boolean[n];

        int sum =0;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int distance = pair.distance;
            int node = pair.node;

            if(visited[node]) continue;

            sum+=distance;
            visited[node] = true;

            for(int neighbour = 0; neighbour < n; neighbour++){
                if(!visited[neighbour]){

                    int currDistance =
                            Math.abs(points[node][0] - points[neighbour][0]) +
                            Math.abs(points[node][1] - points[neighbour][1]);
                    pq.add(new Pair(currDistance, neighbour));
                }
            }
        }

        return sum;
    }
}
