class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String ans = "";
        for(int i = 0; i<strs[0].length(); i++){
            String pref = strs[0].substring(0, i+1);
            for(int j = 0; j<n; j++){
                if(strs[j].length() < i+1 || !pref.equals(strs[j].substring(0, i+1))) return ans;
            }
            ans = pref;
        }

        return ans;
    }
}