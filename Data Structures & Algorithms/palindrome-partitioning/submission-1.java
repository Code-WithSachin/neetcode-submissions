class Solution {
    public boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;

        while(i < j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }

        return j <= i;
    }
    public void check(int start, String s, List<String> currList, List<List<String>> ans){
        if(start == s.length()){
            ans.add(new ArrayList<>(currList));
            return;
        }

        for(int end = start+1; end<=s.length(); end++){
            String subString = s.substring(start, end);
            if(isPalindrome(subString)){
                currList.add(subString);
                check(end, s, currList, ans);
                currList.remove(currList.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        check(0, s, new ArrayList<>(), ans);
        return ans;
    }
}
