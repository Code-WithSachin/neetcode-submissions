class Solution {
    public int checkPath(int indexI, int indexJ, int[][] matrix, int memo[][]){
        int n = matrix.length, m = matrix[0].length;

        if(memo[indexI][indexJ] != 0) return memo[indexI][indexJ];

        int rowDir[] = {-1, 0, 1, 0};
        int colDir[] = {0, 1, 0, -1};
        int ans = 1;
        for(int i = 0; i<4; i++){
            int nextRow = indexI+rowDir[i];
            int nextCol = indexJ+colDir[i];

            if(nextRow >=0 && nextRow < n && nextCol >= 0 && nextCol < m
            && matrix[nextRow][nextCol] > matrix[indexI][indexJ]){
               ans = Math.max(ans, 1+checkPath(nextRow, nextCol, matrix, memo));
            }
        }
        return memo[indexI][indexJ] = ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int memo[][] = new int[n][m];

        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int currAns = checkPath(i, j, matrix, memo);
                System.out.println(i+" "+j+" "+currAns);
                ans = Math.max(ans, currAns);
            }
        }

        return ans;
    }
}
