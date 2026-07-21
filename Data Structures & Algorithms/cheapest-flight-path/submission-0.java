class Solution {

    int ans = Integer.MAX_VALUE;

    public void dfs(int src, int dst, ArrayList<ArrayList<int[]>> adj,
                    boolean[] visited, int stops, int cost) {

        if (stops < -1) return;

        if (src == dst) {
            ans = Math.min(ans, cost);
            return;
        }

        visited[src] = true;

        for (int[] neighbour : adj.get(src)) {
            int next = neighbour[0];
            int price = neighbour[1];

            if (!visited[next] && cost + price < ans) {
                dfs(next, dst, adj, visited, stops - 1, cost + price);
            }
        }

        visited[src] = false; // Backtrack
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        boolean[] visited = new boolean[n];

        dfs(src, dst, adj, visited, k, 0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}