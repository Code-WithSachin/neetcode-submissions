/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        // Case 1: Rob current node
        int robCurrent = root.val;

        if (root.left != null) {
            robCurrent += dfs(root.left.left);
            robCurrent += dfs(root.left.right);
        }

        if (root.right != null) {
            robCurrent += dfs(root.right.left);
            robCurrent += dfs(root.right.right);
        }

        // Case 2: Don't rob current node
        int skipCurrent = dfs(root.left) + dfs(root.right);

        int result = Math.max(robCurrent, skipCurrent);

        memo.put(root, result);

        return result;
    }
}