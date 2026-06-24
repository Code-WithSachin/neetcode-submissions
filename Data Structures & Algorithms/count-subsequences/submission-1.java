class Solution {
    public int check(int i, int j, String s, String t, int[][]memo){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        int result = 0;
        if(s.charAt(i) == t.charAt(j)){
            result = check(i+1, j+1, s, t, memo)+check(i+1, j, s, t, memo);
        }else{
            result = check(i+1, j, s, t, memo);
        }

        return memo[i][j] = result;
    }
    public int numDistinct(String s, String t) {
        int[][]memo = new int[s.length()][t.length()];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return check(0, 0, s, t, memo);
    }
}
