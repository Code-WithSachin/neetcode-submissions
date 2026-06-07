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
    int dia =0;
    public int traverse(TreeNode root){
        if(root == null) return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);

        dia = Math.max(dia, left+right);

        return 1+Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return dia;
    }
}
