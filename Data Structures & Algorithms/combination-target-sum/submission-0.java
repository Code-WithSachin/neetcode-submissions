class Solution {
    public void letsCount(int[] candidates, int target, int i, List<Integer> helper, Set<List<Integer>> ans){
        if(i == candidates.length) return;

        if(target < 0) return;

        if(target == 0) ans.add(new ArrayList<>(helper));

        helper.add(candidates[i]);
        letsCount(candidates, target-candidates[i], i, helper, ans);
        target+=helper.get(helper.size()-1);
        helper.remove(helper.size()-1);
        letsCount(candidates, target-candidates[i], i+1, helper, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> ans = new HashSet<>();

        letsCount(candidates, target, 0, new ArrayList<>(), ans);

        return new ArrayList<>(ans);
    }
}
