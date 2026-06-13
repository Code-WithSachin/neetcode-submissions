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
    
    // 1. Traverse first and last rows
    for (int j = 0; j < m; j++) {
        if (grid[0][j] == 1) check(0, j, grid);
        if (grid[n - 1][j] == 1) check(n - 1, j, grid);
    }
    
    // 2. Traverse first and last columns
    for (int i = 0; i < n; i++) {
        if (grid[i][0] == 1) check(i, 0, grid);
        if (grid[i][m - 1] == 1) check(i, m - 1, grid);
    }

    // 3. Count remaining trapped 1s
    int countOfOnes = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 1) {
                countOfOnes++;
            }
        }
    }
    return countOfOnes;
}
}