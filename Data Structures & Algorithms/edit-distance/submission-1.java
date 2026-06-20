class Solution {
    public int check(int i, int j, String word1, String word2, int memo[][]){
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;

        if(memo[i][j] != -1) return memo[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            return check(i+1, j+1, word1, word2, memo);
        }

        int insert = 1+check(i, j+1, word1, word2, memo);
        int delete = 1+check(i+1, j, word1, word2, memo);
        int replace = 1+check(i+1, j+1, word1, word2, memo);

        return memo[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        int memo[][] = new int[word1.length()][word2.length()];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return check(0, 0, word1, word2, memo);
    }
}
