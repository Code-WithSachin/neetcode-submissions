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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p==null || q == null) return false;
        if(p.val != q.val) return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }
    public TreeNode findNode(TreeNode root, int val){
        if(root == null) return null;

        if(root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if(left != null) return left;
        return findNode(root.right, val);
    }  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(root.val == subRoot.val){
            if(isSameTree(root, subRoot)) return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
