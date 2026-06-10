class Solution {

    void dfs(int start, int[] candidates, int target,
             List<Integer> curr, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicates at the same level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            curr.add(candidates[i]);
            dfs(i + 1, candidates, target - candidates[i], curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        dfs(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }
}