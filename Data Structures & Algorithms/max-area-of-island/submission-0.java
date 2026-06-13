class Solution {
    public void check(int[][] grid, int indexI, int indexJ, int [] currArea){

        int n = grid.length, m = grid[0].length;

        // Base case: check boundaries and if the current cell is water/visited (0)
        if(indexI < 0 || indexJ < 0 || indexI >= n || indexJ >= m || grid[indexI][indexJ] == 0) return;

        // Mark the current land cell as visited by setting it to 0
        grid[indexI][indexJ] = 0;
        currArea[0] = currArea[0]+1;
        System.out.println(currArea+" ");
        int directionX[] = {1, 0, -1, 0};
        int directionY[] = {0, -1, 0, 1};

        // Explore all 4 adjacent directions
        for(int i = 0; i < 4; i++){
            check(grid, indexI + directionX[i], indexJ + directionY[i], currArea);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int maxArea = 0;
        int currArea[]= new int[1];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // Check for land represented by the integer 1
                if(grid[i][j] == 1){
                    currArea[0] = 0;
                    check(grid, i, j, currArea);
                    maxArea = Math.max(currArea[0], maxArea);
                }
            }
        }

        return maxArea;
    }
}