class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        // Step 1: Find ALL boundary land cells and push them into the queue simultaneously
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Check if it's an edge/boundary cell
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        queue.add(new int[]{i, j});
                        visited[i][j] = true; // Mark as visited right away
                    }
                }
            }
        }
        
        // Direction arrays for 4-directional movement (Up, Right, Down, Left)
        int[] dirRow = {-1, 0, 1, 0};
        int[] dirCol = {0, 1, 0, -1};
        
        // Step 2: Multi-Source BFS traversal
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            
            // Explore all 4 neighbors
            for (int i = 0; i < 4; i++) {
                int nRow = r + dirRow[i];
                int nCol = c + dirCol[i];
                
                // If neighbor is valid, unvisited, and is land (1), it can escape!
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m 
                    && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                    
                    visited[nRow][nCol] = true;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
        
        // Step 3: Count remaining unvisited 1s (the true enclaves)
        int enclavesCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If it's land and our boundary wave never managed to reach it
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclavesCount++;
                }
            }
        }
        
        return enclavesCount;
    }
}