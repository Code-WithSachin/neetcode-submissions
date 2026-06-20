class Solution {
    public int check(int indexI, int indexJ, String str1, String str2, int memo[][]){
        if(indexI == str1.length() || indexJ == str2.length()) return 0;

        if(memo[indexI][indexJ] != -1) return memo[indexI][indexJ];

        if(str1.charAt(indexI) == str2.charAt(indexJ)){
            return memo[indexI][indexJ] = 1+check(indexI+1, indexJ+1, str1, str2, memo);
        }

        // SCENARIO 2: Mismatch (Put this in an implicit 'else' by returning directly)
        int skipI = check(indexI + 1, indexJ, str1, str2, memo);
        int skipJ = check(indexI, indexJ + 1, str1, str2, memo);

        return memo[indexI][indexJ] = Math.max(skipI, skipJ);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int memo[][] = new int [text1.length()][text2.length()];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return check(0, 0, text1, text2, memo);
    }
}
