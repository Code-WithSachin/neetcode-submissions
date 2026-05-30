class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n=arr.length;
        int i=0,j=n-1;
        int sum=0;
        int ans[]=new int[2];
       while(i<j)
       {
           sum=arr[i]+arr[j];
           if(sum==target)
           {
               ans[0]=i+1;
               ans[1]=j+1;
               return ans;
           }
           else if(sum>target)
           {
               j--;
           }
           else{
            i++;
           }
       }
        return ans;
    }
}
