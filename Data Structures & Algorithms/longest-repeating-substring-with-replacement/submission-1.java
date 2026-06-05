class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        
        int i = 0, j = 0, maxFreq = 0, ans = 0;
        for(i = 0; i<n; i++){
            char charAtI = s.charAt(i);
            map.put(charAtI, map.getOrDefault(charAtI, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(charAtI));

            while((i-j+1)-maxFreq > k){
                char charAtJ = s.charAt(j);
                map.put(charAtJ, map.get(charAtJ)-1);
                j++;
            }

            ans = Math.max(ans, i-j+1);
        }

        return ans;
    }
}
