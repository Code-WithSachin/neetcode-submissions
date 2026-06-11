
class Solution {
    public void subsets(int index, int[] nums, List<Integer> list, List<List<Integer>> ans){
        
        ans.add(new ArrayList<>(list));
            
        for(int i = index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            subsets(i+1, nums, list, ans);
            list.remove(list.size()-1);
        }
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}

