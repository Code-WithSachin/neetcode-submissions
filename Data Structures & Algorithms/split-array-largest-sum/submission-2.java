class Solution {
    public boolean isPossible(int currWeight, int k, int[]nums){
        int requiredDays = 1;
        int sum = 0;
        for(int weight: nums){
            sum+=weight;
            if(sum > currWeight){
                sum = weight;
                requiredDays++;
            }
        }
        return requiredDays <= k;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for(int weight: nums){
            high+=weight;
            low = Math.max(low, weight);
        }

        int ans = 0;
        while(low <= high){
            int mid = (low+high)/2;
            System.out.println(mid);
            if(isPossible(mid, k, nums)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}