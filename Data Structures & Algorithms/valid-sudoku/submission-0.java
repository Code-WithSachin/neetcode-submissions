class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                char ch = board[i][j];
                if(ch == '.') continue;
                if(set.contains(ch+"_R_"+i) || set.contains(ch+"_C_"+j)
                || set.contains(ch+"_B_"+i/3+"_"+j/3)){
                    return false;
                }else{
                    set.add(ch+"_R_"+i);
                    set.add(ch+"_C_"+j);
                    set.add(ch+"_B_"+i/3+"_"+j/3);
                }
            }
        }
        return true;
    }
}
