class Solution {
    public boolean isPossible(int max, int k, int[]nums){
        int sum = 0, partitions = 1;

        for(int num: nums){
            sum+=num;
            if(sum > max){
                partitions++;
                sum = num;
            }
        }

        return partitions <= k; 
    }
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        for(int num: nums){
            low = Math.max(low, num);
            high+=num;
        }

        int ans = 0;
        while(low <= high){
            int mid = (high+low)/2;
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