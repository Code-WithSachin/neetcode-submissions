class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         HashMap<Integer, Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a, b)->a[1]-b[1]);
        for(int key:map.keySet()){
            pq.add(new int []{key, map.get(key)});
            if(pq.size()>k) pq.poll();
        }
        int ans[]=new int[k];
        int i=0;
        while(!pq.isEmpty()){
            int num[]=pq.poll();
            ans[i++]=num[0];
        }
        return ans;
    }
}

// class Solution {
//     static class Pair {
//         int num;
//         int freq;

//         Pair(int num, int freq) {
//             this.num = num;
//             this.freq = freq;
//         }

//         // Add this getter so Pair::getFreq works!
//         public int getFreq() {
//             return this.freq;
//         }
//     }

//     public int[] topKFrequent(int[] nums, int k) {
//         // Step 1: Count total frequencies using a HashMap
//         Map<Integer, Integer> freqMap = new HashMap<>();
//         for (int num : nums) {
//             freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//         }

//         // Step 2: Build a list of ALL Pairs
//         List<Pair> pairList = new ArrayList<>();
//         for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
//             pairList.add(new Pair(entry.getKey(), entry.getValue()));
//         }

//         pairList.sort((p1, p2) -> Integer.compare(p2.freq, p1.freq));
//         // pairList.sort(Comparator.comparing(Pair::getFreq).reversed());

//         // Step 4: Simply pull the numbers from the first k elements!
//         int[] result = new int[k];
//         for (int i = 0; i < k; i++) {
//             result[i] = pairList.get(i).num;
//         }
        
//         return result;
//     }
// }