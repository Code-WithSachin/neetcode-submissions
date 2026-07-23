class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for(int num: nums){
            if(num == 0) count0++;
            else if(num == 1) count1++;
            else count2++;
        }
        
        int j = 0, freq = 0;
        for(int i = 0; i<=2; i++){
            if(i == 0) freq = count0;
            else if(i == 1) freq = count1;
            else freq = count2;
            while(freq-- > 0){
                nums[j++] = i;
            }
        }
    }
}
