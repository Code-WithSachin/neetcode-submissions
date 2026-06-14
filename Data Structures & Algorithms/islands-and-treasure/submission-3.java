class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // Edge case safety
        if (grid == null || grid.length == 0) return;
        
        int n = grid.length, m = grid[0].length;

        // Optimization 1: Store primitive int arrays instead of Object Lists
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j}); // Only need row and col
                }
            }
        }

        // Clockwise: Up, Right, Down, Left
        int dirRow[] = {-1, 0, 1, 0};
        int dirCol[] = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int i = 0; i < 4; i++){
                int indexI = r + dirRow[i];
                int indexJ = c + dirCol[i];

                // Using Integer.MAX_VALUE makes the code cleaner to read than 2147483647
                if(indexI >= 0 && indexJ >= 0 && indexI < n && indexJ < m 
                && grid[indexI][indexJ] == Integer.MAX_VALUE){
                    
                    // Optimization 2: Read the current distance directly from the grid!
                    grid[indexI][indexJ] = grid[r][c] + 1;
                    
                    queue.add(new int[]{indexI, indexJ});
                }
            }
        }
    }
}