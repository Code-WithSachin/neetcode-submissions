class Solution {
    public String minWindow(String s, String t) {
        int totalFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
            totalFreq++;
        }

        int left = 0, right =0, length = Integer.MAX_VALUE;
        String ans = "";

        for(right = 0; right < s.length(); right++){
            char currChar = s.charAt(right);
            if(map.containsKey(currChar)){
                if(map.get(currChar) > 0){
                    totalFreq--;
                }
                map.put(currChar, map.get(currChar)-1);
            }

            while(totalFreq == 0 && left <= right){
                if((right - left + 1) < length){
                    length = right - left + 1;
                    ans = s.substring(left, right+1);
                }

                char removeChar = s.charAt(left);
                if(map.containsKey(removeChar)){
                    map.put(removeChar, map.get(removeChar)+1);
                    if(map.get(removeChar) > 0){
                        totalFreq++;
                    }
                }
                left++;
            }
        }
        return ans;
    }
}
