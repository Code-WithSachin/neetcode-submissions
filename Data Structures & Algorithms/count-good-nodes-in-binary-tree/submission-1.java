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
    public int count(TreeNode root, int max){
        if(root == null) return 0;

        int curr = 0;
        if(root.val >= max) curr++;

        max = Math.max(max, root.val);

        int leftCount = count(root.left, max);
        int rightCount = count(root.right, max);

        return curr + leftCount + rightCount;
    }
    public int goodNodes(TreeNode root) {
        return count(root, Integer.MIN_VALUE);
    }
}
