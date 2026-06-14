class Solution {
    public void dfs(int row, int col, int prevValue, int[][] heights, boolean[][] ocean){
        int n = heights.length, m = heights[0].length;
        if(row < 0 || col < 0 || row >= n || col >= m || ocean[row][col]) return;

        if(heights[row][col] < prevValue) return;

        ocean[row][col] = true;

        int dirRow [] = {-1, 0, 1, 0};
        int dirCol [] = {0, 1, 0, -1};

        for(int i =0; i<4; i++){
            dfs(row+dirRow[i], col+dirCol[i], heights[row][col], heights, ocean);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = heights.length, m = heights[0].length;
        boolean pacific[][] =  new boolean[n][m];
        boolean atlantic[][] =  new boolean[n][m];
        
        for(int i =0; i<n; i++){
            dfs(i, 0, Integer.MIN_VALUE, heights, pacific);
            dfs(i, m-1, Integer.MIN_VALUE, heights, atlantic);
        }

        for(int i =0; i<m; i++){
            dfs(0, i, Integer.MIN_VALUE, heights, pacific);
            dfs(n-1, i, Integer.MIN_VALUE, heights, atlantic);
        }

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}
