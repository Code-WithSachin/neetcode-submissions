class KthLargest {
    Queue<Integer> queue;
    int kth;
    public KthLargest(int k, int[] nums) {
        kth = k;
        queue = new PriorityQueue<>();

        for(int num: nums){
            queue.add(num);

            if(queue.size() > k) queue.poll();
        }

        System.out.println(queue.size());

    }
    
    public int add(int val) {
        queue.add(val);

        if(queue.size()>kth) queue.poll();
        
        return queue.peek();
    }
}
