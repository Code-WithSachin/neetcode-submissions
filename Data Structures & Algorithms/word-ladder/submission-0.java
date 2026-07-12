class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String word = queue.poll();

                if (word.equals(endWord))
                    return level;

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[i] = ch;
                        String newWord = new String(arr);

                        if (set.contains(newWord)) {

                            queue.offer(newWord);
                            set.remove(newWord);    // mark visited
                        }
                    }

                    arr[i] = original; // backtrack
                }
            }

            level++;
        }

        return 0;
    }
}