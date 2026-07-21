class Solution {
    class Pair {
        int stops;
        int source;
        int cost;

        Pair(int stops, int source, int cost) {
            this.stops = stops;
            this.source = source;
            this.cost = cost;
        }
    }

    class FlightPair {
        int flightTo;
        int cost;

        FlightPair(int flightTo, int cost) {
            this.flightTo = flightTo;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Create adjacency list
        ArrayList<ArrayList<FlightPair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] row : flights) {
            adj.get(row[0]).add(new FlightPair(row[1], row[2]));
        }

        // Step 2: Initialize cost array
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        // Step 3: Priority Queue for BFS (sorted by cost)
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, src, 0)); 

        // Step 4: BFS (Modified Dijkstra)
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int stops = pair.stops;
            int source = pair.source;
            int prevFlightCost = pair.cost;

            if(stops > k) continue;
            // If we have remaining stops, explore neighbors
            for (FlightPair flight : adj.get(source)) {
                int flightTo = flight.flightTo;
                int thisFlightCost = flight.cost;

                // If the new cost is cheaper, update and add to queue
                if (prevFlightCost+thisFlightCost < cost[flight.flightTo]) {
                    cost[flight.flightTo] = prevFlightCost+thisFlightCost ;
                    queue.add(new Pair(stops+1, flight.flightTo, prevFlightCost+thisFlightCost ));
                }
            }
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}