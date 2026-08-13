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
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;

        if(map.containsKey(root)) return map.get(root);

        int robbed = root.val;

        if(root.left != null){
            robbed+=rob(root.left.left);
            robbed+=rob(root.left.right);
        }
        if(root.right != null){
            robbed+=rob(root.right.left);
            robbed+=rob(root.right.right);
        }

        int notRobbed = rob(root.left) + rob(root.right);
        map.put(root, Math.max(robbed, notRobbed));
        return map.get(root);
    }
}