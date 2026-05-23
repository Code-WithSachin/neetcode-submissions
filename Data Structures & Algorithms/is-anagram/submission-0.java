class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] charCountArray = new int[26];

        for(int i = 0; i < s.length(); i++){
            charCountArray[s.charAt(i)-'a']++;
            charCountArray[t.charAt(i)-'a']--;
        }

        for(int i: charCountArray){
            if(i != 0) return false;
        }

        return true;

    }
}
