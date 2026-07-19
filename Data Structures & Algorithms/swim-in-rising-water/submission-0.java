class Solution {
    class Pair{
        int weight;
        int row;
        int col;

        public Pair(int weight, int row, int col){
            this.weight = weight;
            this.row = row;
            this.col = col;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.weight - b.weight);
        pq.add(new Pair(grid[0][0], 0, 0));

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int[]rDir = {-1, 0, 1, 0};
        int[]cDir = {0, 1, 0, -1};

        int ans = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int row = pair.row;
            int col = pair.col;
            int weight = pair.weight;

            ans = Math.max(ans, weight);
            if(row == n-1 && col == n-1) break;

            for(int i = 0; i<4; i++){
                int newRow = row+rDir[i];
                int newCol = col+cDir[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n 
                    && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    pq.add(new Pair(grid[newRow][newCol], newRow, newCol));
                }
            }
        }
        return ans;
    }
}
