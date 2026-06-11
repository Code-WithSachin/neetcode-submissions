class Solution {
    public void subsets(int index, int[] nums, List<Integer> list, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
            

        list.add(nums[index]);
        subsets(index+1, nums, list, ans);
        list.remove(list.size()-1);
        subsets(index+1, nums, list, ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}
