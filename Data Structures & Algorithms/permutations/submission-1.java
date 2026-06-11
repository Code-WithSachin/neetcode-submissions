class Solution {
    public void helper(int index, int nums[], boolean visited[], List<Integer> list, List<List<Integer>> ans){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i =0; i<nums.length; i++){

            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                helper(i+1, nums, visited, list, ans);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean [] visited = new boolean[nums.length];

        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, visited, new ArrayList<>(), ans);

        return ans;
    }
}
