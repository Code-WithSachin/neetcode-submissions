class Solution {
    public void build(int[]nums, int i, List<Integer> helper, List<List<Integer>> ans){
        if(i == nums.length){
            ans.add(new ArrayList<>(helper));
            return;
        }

        helper.add(nums[i]);
        build(nums, i+1, helper, ans);
        helper.remove(helper.size()-1);
        build(nums, i+1, helper, ans);

        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> helper = new ArrayList<>();

        build(nums, 0, helper, ans);

        return ans;
    }
}
