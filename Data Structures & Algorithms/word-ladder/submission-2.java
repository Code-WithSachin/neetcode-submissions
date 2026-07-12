class Solution {
    class Pair{
        String str;
        int level;
        public Pair(String str, int level){
            this.str = str;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.str;
            int level = pair.level;
            if(word.equals(endWord)) return level;

            for(int i = 0; i<word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[]replacedWordArr = word.toCharArray();
                    replacedWordArr[i] = ch;
                    
                    String replacedWord = new String(replacedWordArr);
                    if(set.contains(replacedWord)){
                        queue.add(new Pair(replacedWord, level+1));
                        set.remove(replacedWord);
                    }
                }
            }
        }

        return 0;
    }
}