class Solution {
    public void check(char[][] grid, int indexI, int indexJ){

        int n = grid.length, m = grid[0].length;

        if(indexI < 0 || indexJ < 0 || indexI >=n || indexJ >=m || grid[indexI][indexJ] == '0') return;

        grid[indexI][indexJ] = '0';

        int directionX[] = {1, 0, -1, 0};
        int directionY[] = {0, -1, 0, 1};

        for(int i =0; i<4; i++){
            check(grid, indexI+directionX[i], indexJ+directionY[i]);
        }
    }
    public int numIslands(char[][] grid) {
        int count =0;
        for(int i = 0; i<grid.length; i++){
            for(int j =0; j< grid[0].length; j++){
                if(grid[i][j]=='1'){
                    check(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}
