class Solution {
    class Pair{
        int stops;
        int source;
        int cost;

        public Pair(int stops, int source, int cost){
            this.stops = stops;
            this.source = source;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        Queue<Pair> queue = new LinkedList<>();
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        queue.add(new Pair(0, src, 0));
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int currStops = pair.stops;
            int source = pair.source;
            int currCost = pair.cost;

            if(currStops > k) continue;

            for(int[] neighbour: adj.get(source)){
                int flightTo = neighbour[0];
                int thisFlightCost = neighbour[1];

                int newCost = currCost+thisFlightCost;

                if(newCost < costs[flightTo]){
                    queue.add(new Pair(currStops+1, flightTo, newCost));
                    costs[flightTo] = newCost;
                    if(flightTo == dst){
                        ans = Math.min(ans, newCost);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}