class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length, freshCount =0;

        Queue<List<Integer>> queue = new LinkedList<>();

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.add(Arrays.asList(i, j, 0));
                }else if(grid[i][j] == 1){
                    freshCount++;
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
                && grid[indexI][indexJ] == 1){
                    freshCount--;
                    grid[indexI][indexJ] = 2;
                    queue.add(Arrays.asList(indexI, indexJ, list.get(2)+1));
                }
            }
        }

        return freshCount > 0 ? -1 : ans;
    }
}
