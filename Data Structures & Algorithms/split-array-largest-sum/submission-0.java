class Solution {
    public boolean isPossible(int mid, int nums[], int k){
        
        int sum = 0, ans =1;
        for(int num: nums){
            sum+=num;
            if(sum > mid){
                ans++;
                sum = num;
            }
        }
        return ans <= k;
    }
    public int splitArray(int[] nums, int k) {
        // code here
        int low = Integer.MIN_VALUE, high =0, ans = Integer.MAX_VALUE;
        
        for(int num: nums){
            low = Math.max(low, num);
            high+=num;
        }
        
        while(low <= high){
            
            int mid = (low+high)/2;
            
            if(isPossible(mid, nums, k)){
                ans = Math.min(ans, mid);
                high = mid-1;
            }else{
               low = mid+1; 
            }
        }
        return ans;
    }
}