class Solution {
    public String checkPalindrome(int start, int end, String s){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String overallLongest = "";
        for(int i = 0; i<n; i++){
            String str1 = checkPalindrome(i, i, s);
            String str2 = checkPalindrome(i, i+1, s);

            String currLongest =  str1.length() > str2.length() ? str1 : str2;

            overallLongest = overallLongest.length() > currLongest.length() ? overallLongest : currLongest;
        }

        return overallLongest;
    }
}