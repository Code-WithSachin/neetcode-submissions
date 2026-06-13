class Solution {
    public int check(int[][] grid, int indexI, int indexJ){
        int n = grid.length, m = grid[0].length;

        // Base case: if out of bounds or water, this cell adds 0 to the area
        if(indexI < 0 || indexJ < 0 || indexI >= n || indexJ >= m || grid[indexI][indexJ] == 0) {
            return 0; 
        }

        // Mark as visited
        grid[indexI][indexJ] = 0;

        // Count this current cell as 1
        int area = 1;

        int directionX[] = {1, 0, -1, 0};
        int directionY[] = {0, -1, 0, 1};

        // Add the areas returned by all neighbors
        for(int i = 0; i < 4; i++){
            area += check(grid, indexI + directionX[i], indexJ + directionY[i]);
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    // The method returns the total area of the island found
                    int islandArea = check(grid, i, j);
                    maxArea = Math.max(islandArea, maxArea);
                }
            }
        }
        return maxArea;
    }
}