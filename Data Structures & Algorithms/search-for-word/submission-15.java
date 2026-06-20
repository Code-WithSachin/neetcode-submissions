class Solution {
    public boolean check(int indexI, int indexJ, int wordIndex, char[][] board, String word){
        // Optimization 2: Ultimate Victory Condition caught at the top
        if(wordIndex == word.length()) return true;

        int n = board.length, m = board[0].length;

        // Optimization 1: Save character and mutate board to avoid a 'visited' array
        char temp = board[indexI][indexJ];
        board[indexI][indexJ] = '#';

        int rowDir[] = {-1, 0, 1, 0};
        int colDir[] = {0, 1, 0, -1};
        
        for(int i = 0; i < 4; i++){
            int nextRow = indexI + rowDir[i];
            int nextCol = indexJ + colDir[i];

            // Clean boundary check using the board mutation instead of visited matrix
            if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m
            && board[nextRow][nextCol] != '#' && board[nextRow][nextCol] == word.charAt(wordIndex)){
                
               if(check(nextRow, nextCol, wordIndex + 1, board, word)) return true;
            }
        }
        
        // Backtrack: Restore the original character before leaving
        board[indexI][indexJ] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    // Start checking. If the word is 1 char long, index 1 triggers the base case instantly
                    if(check(i, j, 1, board, word)) return true;
                }
            }
        }
        return false;
    }
}