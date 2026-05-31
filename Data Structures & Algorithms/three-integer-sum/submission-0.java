class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> ans = new HashSet<>();

        for(int i = 0; i<n-2; i++){
            int l = i+1, r = n-1;

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > 0){
                    r--;
                }else if(sum < 0){
                    l++;
                }else{
                    ans.add(Arrays.asList(nums[i], nums[l],nums[r]));
                    l++;
                    r--;
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
