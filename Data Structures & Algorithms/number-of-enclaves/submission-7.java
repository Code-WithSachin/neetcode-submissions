class Solution {
    public void check(int indexI, int indexJ, int[][] grid){
        int n = grid.length, m = grid[0].length;
        if(indexI <0 || indexJ < 0 || indexI >= n || indexJ >= m || grid[indexI][indexJ] == 0) return;

        int directionX [] = {1, 0, -1, 0};
        int directionY [] = {0, -1, 0, 1};

        grid[indexI][indexJ] = 0;

        for(int i = 0; i<4; i++){
             check(indexI+directionX[i], indexJ+directionY[i], grid);
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                // Notice the grouped parentheses around the boundary checks
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == 1) {
                    check(i, j, grid);
                }
            }
        }

        int countOfOnes = 0;
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j]==1){
                    countOfOnes++;
                }
            }
        }
        return countOfOnes;
    }
}