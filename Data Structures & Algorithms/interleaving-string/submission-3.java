class Solution {
    public boolean check(int i, int j, String s1, String s2, String s3){
        if(i+j == s3.length()) return true;

        boolean matchS1 = false, matchS2 = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            matchS1 = check(i+1, j, s1, s2, s3);
            if(matchS1) return true;
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            matchS2 = check(i, j+1, s1, s2, s3);
             if(matchS2) return true;
        }

        return matchS1 || matchS2;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        return check(0, 0, s1, s2, s3);
    }
}
