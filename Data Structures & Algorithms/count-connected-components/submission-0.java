class Solution {
    // Standard DFS that recursively marks everything in the same connected component
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        // 1. Create a standard undirected adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Both ways since it's undirected!
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        // 2. The Outer Loop: It sweeps through every single node from 0 to n-1
        for (int i = 0; i < n; i++) {
            // If we hit an unvisited node, it means we found a BRAND NEW component!
            if (!visited[i]) {
                count++; 
                dfs(i, adj, visited); // Clear out the entire component via DFS
            }
        }

        return count;
    }
}