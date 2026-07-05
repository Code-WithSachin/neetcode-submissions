class Solution {

    public boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{node, -1});
        visited[node] = true;

        while (!queue.isEmpty()) {

            int[] pair = queue.poll();
            int curr = pair[0];
            int parent = pair[1];

            for (int neighbour : adj.get(curr)) {

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(new int[]{neighbour, curr});
                } else if (neighbour != parent) {
                    return true;    // Cycle found
                }
            }
        }

        return false;   // No cycle
    }

    public boolean validTree(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                components++;

                if (checkCycle(i, adj, visited)) {
                    return false;
                }
            }
        }

        return components == 1;
    }
}