class Solution {
    public boolean check(int indexI, int indexJ, int wordIndex, char[][] board, String word, boolean[][] visited){
        int n = board.length, m = board[0].length;
        if(wordIndex == word.length()) return true;

        visited[indexI][indexJ] = true;

        int rowDir[] = {-1, 0, 1, 0};
        int colDir[] = {0, 1, 0, -1};
        for(int i = 0; i<4; i++){
            int nextRow = indexI+rowDir[i];
            int nextCol = indexJ+colDir[i];

            if(nextRow >=0 && nextRow < n && nextCol >= 0 && nextCol < m
            && !visited[nextRow][nextCol] && board[nextRow][nextCol] == word.charAt(wordIndex)){
               if(check(nextRow, nextCol, wordIndex+1, board, word, visited)) return true;
            }
        }
        visited[indexI][indexJ] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        // boolean[][] visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[n][m];
                    if(check(i, j, 1, board, word, visited)) return true;
                }
            }
        }
        return false;
    }
}
