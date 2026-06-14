class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length, m = grid[0].length, freshCount =0;

        Queue<List<Integer>> queue = new LinkedList<>();

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == 0){
                    queue.add(Arrays.asList(i, j, 0));
                }else if(grid[i][j] == 2147483647){
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

            for(int i =0; i<4; i++){
                int indexI = list.get(0)+dirRow[i];
                int indexJ = list.get(1)+dirCol[i];

                if(indexI >= 0 && indexJ >= 0 && indexI < n && indexJ < m 
                && grid[indexI][indexJ] == 2147483647){
                    grid[indexI][indexJ] = list.get(2)+1;
                    queue.add(Arrays.asList(indexI, indexJ, list.get(2)+1));
                }
            }
        }
    }
}

