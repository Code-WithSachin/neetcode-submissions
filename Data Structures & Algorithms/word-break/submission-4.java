class Solution {
    public boolean wordBreakHelper(int index, String s, HashSet<String> set, int[]memo){
        if(index == s.length())return true;

        if (memo[index] != 0) {
            return memo[index] == 2; 
        }

        for(int end = index+1; end<=s.length(); end++){
            String subString = s.substring(index, end);

            if(set.contains(subString)){
                if(wordBreakHelper(end, s, set, memo)){
                    memo[index] = 2;
                    return true;
                }
            }
        }
        memo[index] = 1;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int memo[] = new int[s.length()];

        return wordBreakHelper(0, s, set, memo);
    }
}
