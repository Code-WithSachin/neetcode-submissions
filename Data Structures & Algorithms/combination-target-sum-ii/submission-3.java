class Solution {
    public void helper(int index, int target, int[] candidates, List<Integer> list, List<List<Integer>> ans){
        if(target == 0) ans.add(new ArrayList<>(list));

        for(int i = index; i < candidates.length; i++){
            if(i != index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;

            list.add(candidates[i]);
            helper(i+1, target-candidates[i], candidates, list, ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);

       List<List<Integer>> ans = new ArrayList<>();
       helper(0, target, candidates, new ArrayList<>(), ans); 

       return ans;
    }
}
