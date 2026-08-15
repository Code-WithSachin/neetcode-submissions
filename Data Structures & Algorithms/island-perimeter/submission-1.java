class Solution {

    public int check(int[][] grid, int indexI, int indexJ) {

        int n = grid.length;
        int m = grid[0].length;

        // Outside the grid OR water
        // This side contributes 1 to perimeter
        if (indexI < 0 || indexJ < 0 ||
            indexI >= n || indexJ >= m ||
            grid[indexI][indexJ] == 0) {
            return 1;
        }

        // Already visited land
        if (grid[indexI][indexJ] == -1) {
            return 0;
        }

        // Mark as visited
        grid[indexI][indexJ] = -1;

        int directionX[] = {1, 0, -1, 0};
        int directionY[] = {0, -1, 0, 1};

        int perimeter = 0;

        for (int i = 0; i < 4; i++) {
            perimeter += check(
                grid,
                indexI + directionX[i],
                indexJ + directionY[i]
            );
        }

        return perimeter;
    }

    public int islandPerimeter(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    return check(grid, i, j);
                }
            }
        }

        return 0;
    }
}