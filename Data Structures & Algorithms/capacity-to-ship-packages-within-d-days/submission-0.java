class Solution {
    public boolean isPossible(int currWeight, int days, int[]weights){
        int requiredDays = 1;
        int sum = 0;
        for(int weight: weights){
            sum+=weight;
            if(sum > currWeight){
                sum = weight;
                requiredDays++;
            }
        }
        return requiredDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int weight: weights){
            high+=weight;
            low = Math.max(low, weight);
        }

        int ans = 0;
        while(low <= high){
            int mid = (low+high)/2;
            System.out.println(mid);
            if(isPossible(mid, days, weights)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}