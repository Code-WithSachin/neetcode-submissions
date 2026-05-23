class Solution {
    class Pair implements Comparable<Pair>{
        int num;
        int freq;
        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair other){
            return Integer.compare(other.freq, this.freq);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {

        Arrays.sort(nums);

        List<Pair> freqList = new ArrayList<>();
        
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[i] != nums[j]){
                Pair pair = new Pair(nums[i], j-i);
                i = j;
                freqList.add(pair);
            }
        }

        freqList.add(new Pair(nums[i], nums.length-i));

        Collections.sort(freqList);

        int[] ans = new int[k];

        for(int j = 0; j < k; j++){
            ans[j] = freqList.get(j).num;
        }    

        return ans;            
    }
}
