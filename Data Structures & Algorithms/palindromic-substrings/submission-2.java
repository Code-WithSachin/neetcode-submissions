class Solution {
    public int checkPalindrome(int start, int end, String s){
        int count = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            count++;
            start--;
            end++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int totalCount = 0;
        for(int i = 0; i<n; i++){
            totalCount += checkPalindrome(i, i, s);
            totalCount += checkPalindrome(i, i+1, s);
        }

        return totalCount;
    }
}