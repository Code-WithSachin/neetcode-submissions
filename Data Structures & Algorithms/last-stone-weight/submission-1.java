class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->Integer.compare(b, a));

        for(int i = 0; i<stones.length; i++){
            queue.add(stones[i]);
        }

        while(queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();

            int collisionEffect = Math.abs(a-b);
            if(collisionEffect!=0) queue.add(collisionEffect);
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }
}
