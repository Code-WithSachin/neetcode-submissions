class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<List<Integer>> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.add(Arrays.asList(i, j, 0));
                }
            }
        }

        int ans = 0;
        // Clockwise: Up, Right, Down, Left
        int dirRow[] = {-1, 0, 1, 0};
        int dirCol[] = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            List<Integer> list = queue.poll();
            ans = Math.max(ans, list.get(2));

            for(int i =0; i<4; i++){
                int indexI = list.get(0)+dirRow[i];
                int indexJ = list.get(1)+dirCol[i];

                if(indexI >= 0 && indexJ >= 0 && indexI < n && indexJ < m 
                && !visited[indexI][indexJ] && grid[indexI][indexJ] == 1){
                    visited[indexI][indexJ] = true;
                    grid[indexI][indexJ] = 2;
                    queue.add(Arrays.asList(indexI, indexJ, list.get(2)+1));
                }
            }
        }

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}
