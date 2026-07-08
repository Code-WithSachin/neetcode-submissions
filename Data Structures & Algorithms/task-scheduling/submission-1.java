class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int freq : map.values()) {
            pq.add(freq);
        }

        // {remainingFrequency, availableTime}
        Queue<int[]> queue = new LinkedList<>();

        int time = 0;

        while (!pq.isEmpty() || !queue.isEmpty()) {

            time++;

            if (!pq.isEmpty()) {

                int freq = pq.poll();
                freq--;

                if (freq > 0) {
                    queue.add(new int[]{freq, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                pq.add(queue.poll()[0]);
            }
        }

        return time;
    }
}