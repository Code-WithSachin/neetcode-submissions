class Solution {
    public int numDecodingsHelper(int index, String s, int [] memo){
        if(index == s.length()) return 1;
        if(s.charAt(index) == '0') return 0;

        if(memo[index] != -1) return memo[index];

        int result = numDecodingsHelper(index+1, s, memo);
        if(index + 2 <= s.length() && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) < '7'))){
            result+=numDecodingsHelper(index+2, s, memo);
        }

        return memo[index] = result;
    }
    public int numDecodings(String s) {
        int [] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecodingsHelper(0, s, memo);
    }
}
