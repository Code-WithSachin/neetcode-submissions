class Solution {
    public boolean isSafe(int row, int col, char[][] grid){
        int[]rowDir = {-1, -1, -1};
        int[]colDir = {-1, 0, 1};

        for(int i = 0; i<3; i++){
            int newRow = row+rowDir[i];
            int newCol = col+colDir[i];

            while(newRow >= 0 && newCol >= 0 && newCol < grid[0].length){
                if(grid[newRow][newCol] == 'Q') return false;
                newRow+=rowDir[i];
                newCol+=colDir[i];
            }
        }
        return true;
    }
    public void solve(int row, char[][] grid, List<List<String>> ans){
        if(row == grid.length){
            List<String> temp = new ArrayList<>();
            for(char[] currRow: grid){
                temp.add(new String(currRow));
            }
            ans.add(temp);
            return;
        }

        for(int i = 0; i<grid[0].length; i++){
            if(isSafe(row, i, grid)){
                grid[row][i] = 'Q';
                solve(row+1, grid, ans);
                grid[row][i] = '.';
            }
        }
        return;
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(char row[]: grid){
            Arrays.fill(row, '.');
        }

        solve(0, grid, ans);
        return ans;
    }
}
