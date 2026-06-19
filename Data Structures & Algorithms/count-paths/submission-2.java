class Solution {
    public int uniquePathsHelper(int row, int col, int memo[][]){
        if(row == -1 || col == -1) return 0;
        if(row == 0 && col == 0) return 1;

        if(memo[row][col] != -1) return memo[row][col];

        int up = uniquePathsHelper(row-1, col, memo);
        int right = uniquePathsHelper(row, col-1, memo);

        return memo[row][col] = up+right;
    }
    public int uniquePaths(int m, int n) {
        int memo[][] = new int[m][n];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return uniquePathsHelper(m-1, n-1, memo);
    }
}
