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
    public void find(TreeNode root, int k, int [] count, int [] ans){
        if(root == null) return;

        find(root.left, k, count, ans);

        count[0]++;
        if(count[0] == k){
            ans[0] = root.val;
            return;
        }

        find(root.right, k, count, ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        int count[] = {0};
        int ans[] = {0};

        find(root, k, count, ans);
        return ans[0];
    }
}
