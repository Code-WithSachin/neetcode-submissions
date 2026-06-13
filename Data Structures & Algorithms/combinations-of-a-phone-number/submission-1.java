class Solution {
    public void solve(int index, String digits, String map[], StringBuilder str, List<String> ans){
        if(str.length()==digits.length()){
            ans.add(str.toString());
            return;
        }

        int digitNum = digits.charAt(index)-'0';
        String letters = map[digitNum];

        for(int i = 0; i<letters.length(); i++){
            str = str.append(letters.charAt(i));
            solve(index+1, digits, map, str, ans);
            str.deleteCharAt(str.length() - 1);
        }

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) return ans;

        String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(0, digits, map, new StringBuilder(), ans);
        return ans;
    }
}
