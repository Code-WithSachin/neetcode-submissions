class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefSum = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int num: nums){
            prefSum+=num;
            if(map.containsKey(prefSum-k)){
                ans+=map.get(prefSum-k);
            }
            map.put(prefSum, map.getOrDefault(prefSum, 0)+1);
        }

        return ans;
    }
}