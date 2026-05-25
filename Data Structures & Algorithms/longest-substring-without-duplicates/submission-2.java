class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        int i = 0, j = 0, ans = 0;

        for( j = 0; j<s.length(); j++){
            char ch = s.charAt(j);

            while(charCountMap.containsKey(ch)){
                char checkChar = s.charAt(i);
                charCountMap.put(checkChar, charCountMap.get(checkChar)-1);

                if(charCountMap.get(checkChar) == 0) charCountMap.remove(checkChar);
                i++;
            }
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0)+1);
            ans = Math.max(ans, j-i+1);
        }

        return Math.max(ans, j-i);
    }
}
