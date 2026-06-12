class Solution {
    public boolean check(int indexI, int indexJ, char[][] board, 
    boolean[][] visited, String word, int length){
        if(word.length() == length) return true;

        int n = board.length, m = board[0].length;
        if(indexI < 0 || indexJ < 0 || indexI >= n || indexJ >= m || visited[indexI][indexJ]) return false;

        if(board[indexI][indexJ] != word.charAt(length)) return false;

        int directionX [] = {1, 0, -1, 0};
        int directionY [] = {0, -1, 0, 1};
        visited[indexI][indexJ] = true;
        for(int i = 0; i < 4; i++){
            if(check(indexI+directionX[i], indexJ+directionY[i], board, visited, word, length+1)){
                return true;
            }
        }
        visited[indexI][indexJ] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(word.charAt(0) == board[i][j]){
                    if(check(i, j, board, visited, word, 0)) return true;
                }
            }
        }

        return false;
    }
}
