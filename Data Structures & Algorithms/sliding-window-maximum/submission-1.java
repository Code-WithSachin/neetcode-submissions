class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int[] ans = new int[nums.length - k + 1]; 
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        for(i = 0; i<k; i++){
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.addLast(i);
        }
        ans[0] = nums[dq.peekFirst()];

        for(i = k; i<nums.length; i++){

            if(dq.peekFirst() <= i-k) dq.pollFirst();

            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.addLast(i);

            ans[i-k+1] = nums[dq.peekFirst()];
        }

        return ans;
    }
}
