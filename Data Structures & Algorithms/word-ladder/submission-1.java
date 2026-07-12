class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0){
                String word = queue.poll();
                if(word.equals(endWord)) return level;

                for(int i = 0; i<word.length(); i++){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        char[]replacedWordArr = word.toCharArray();
                        replacedWordArr[i] = ch;
                        
                        String replacedWord = new String(replacedWordArr);
                        if(set.contains(replacedWord)){
                            queue.add(replacedWord);
                            set.remove(replacedWord);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }
}