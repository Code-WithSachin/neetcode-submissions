class Solution {
    public void check(char[][] board, int row, int col){
        int n = board.length, m = board[0].length;

        if(row < 0 || col < 0 || row >= n || col >= m 
            || board[row][col] != 'O') return;
        
        board[row][col] = '@';

        int rowDir[] = {-1, 0, 1, 0};
        int colDir[] = {0, 1, 0, -1};

        for(int i =0; i<4; i++){
            int nextRow = row+rowDir[i];
            int nextCol = col+colDir[i];
            
            check(board, nextRow, nextCol);
        }
    }
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if((i == 0 || i == n-1 || j == 0 || j == m-1) && board[i][j] == 'O'){
                    check(board, i, j);
                    board[i][j] = '@';
                }
            }
        }

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
