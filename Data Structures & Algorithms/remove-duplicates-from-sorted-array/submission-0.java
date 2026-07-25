class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        // for(i = 0; i < nums.length; i++){
            for(j = 0; j<nums.length; j++){
                if(nums[i]!=nums[j]){
                    i++;
                    System.out.println(i);
                    nums[i]=nums[j];
                }
            }
        // }
        return i+1;
    }
}
