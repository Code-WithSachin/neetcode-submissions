class Solution {
    public boolean isPalindrome(String subString){
        int i = 0, j = subString.length()-1;

        while(i < j){
            if(subString.charAt(i) != subString.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public void solve(int start, String s, List<String> currList, List<List<String>> ans){
        if(start == s.length()){
            ans.add(new ArrayList<>(currList));
            return;
        }

        for(int end = start; end < s.length(); end++){
            String subString = s.substring(start, end+1);
            if(isPalindrome(subString)){
                currList.add(subString);
                solve(end+1, s, currList, ans);
                currList.remove(currList.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(0, s, new ArrayList<>(), ans);

        return ans;
    }
}
