class Solution {
    public boolean isAlphaNum(char ch){
        return (ch >= 'a' && ch <= 'z') || 
        (ch >= 'A' && ch <= 'Z') || 
        (ch >= '0' && ch <= '9');
    }
    public boolean isPalindrome(String s) {

       int l = 0, r = s.length()-1;

       while(l < r){
        while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
            l++;
        }
        while(r > l && !Character.isLetterOrDigit(s.charAt(r))){
            r--;
        }
        if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
            return false;
        }
        l++; r--;
       } 
       return true;
    }
}
