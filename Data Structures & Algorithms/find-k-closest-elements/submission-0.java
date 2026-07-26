class Solution {
    class Pair{
        int num;
        int diff;

        public Pair(int num, int diff){
            this.num = num;
            this.diff = diff;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->b.diff-a.diff);

        for(int i = 0; i< arr.length; i++){
            int currDiff = Math.abs(arr[i]-x);
            if(pq.size() < k || currDiff < pq.peek().diff){
                pq.add(new Pair(arr[i], currDiff));
            }

            if(pq.size() > k) pq.remove();
        }

        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().num);
        }

        Collections.sort(ans);
        return ans;
    }
}