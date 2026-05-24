class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] pref = new int[n];
        int[] suff = new int[n];
        
        int prefProd = 1;
        for(int i = 0; i<n; i++){
            prefProd = nums[i]*prefProd;
            pref[i] = prefProd;
        }

        int suffProd = 1;
        for(int i = n-1; i>=0; i--){
            suffProd = nums[i]*suffProd;
            suff[i] = suffProd;
        }

         int[] ans = new int[n];  
         for(int i = 0; i<n; i++){
            if(i==0){
                ans[i] = suff[i+1];
            }else if(i==n-1){
                ans[i] = pref[i-1];
            }else{
                ans[i] = pref[i-1]*suff[i+1];
            }
         }

         return ans;      
    }
}  
