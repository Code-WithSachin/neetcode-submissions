class Solution {
    public void check(char[][] board){
        int n = board.length, m = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if((i == 0 || j == 0 || i == n-1 || j == m-1) 
                && board[i][j] == 'O'){
                    queue.add(new int[]{i, j});
                    board[i][j] = '@';
                }
            }
        }

        int rowDir[] = {-1, 0, 1, 0};
        int colDir[] = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int i =0; i<4; i++){
                int nextRow = rowDir[i]+poll[0];
                int nextCol = colDir[i]+poll[1];
                if(nextRow >=0 && nextCol >= 0 && nextRow < n && nextCol < m
                && board[nextRow][nextCol] == 'O'){
                    queue.add(new int[]{nextRow, nextCol});
                    board[nextRow][nextCol] = '@';
                }
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        check(board);

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(board[i][j] == '@'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
