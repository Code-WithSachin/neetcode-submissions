class Solution {
    public boolean isPalindrome(int start, int end, String s){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
    public String check(int start, int end, String s, String [][] memo){
        if(start > end) return "";

        if(isPalindrome(start, end, s)){
            return memo[start][end] =  s.substring(start, end+1);
        }

        if(memo[start][end] != null) return memo[start][end];

        String removeFront = check(start+1, end, s, memo);
        String removeEnd = check(start, end-1, s, memo);

        return memo[start][end] = removeFront.length() > removeEnd.length() ? removeFront : removeEnd;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String [][] memo = new String[n][n];
        return check(0, n-1, s, memo);
    }
}
