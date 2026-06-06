class Solution {
    public boolean matches(int [] s1Map, int [] s2Map){
        for(int i = 0; i<26; i++){
            if(s1Map[i] != s2Map[i]) return false;
        }

        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n > m) return false;
        
        int [] s1Map = new int[26];
        int [] s2Map = new int[26];

        int i =0, j =0;
        while(i < n){
            char charAtI = s1.charAt(i++);
            char charAtJ = s2.charAt(j++);
            s1Map[charAtI-'a']++;
            s2Map[charAtJ-'a']++;
        }

        if(matches(s1Map, s2Map)) return true;
        System.out.println(i+" "+j);

        i =0;
        while(j < m){
            char charAtJ = s2.charAt(j++);
            char charAtI = s2.charAt(i++);
            s2Map[charAtJ - 'a']++;
            s2Map[charAtI - 'a']--;

            if(matches(s1Map, s2Map)) return true;
        }

        return false;
    }
}
