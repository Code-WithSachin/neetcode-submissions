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
    public TreeNode buildTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> indexMap,
    int rootIndex, int left, int right){
        if(left > right) return null;

        TreeNode root = new TreeNode(preorder[rootIndex]);

        int indexInInorder = indexMap.get(preorder[rootIndex]);
        int sizeOfLeftSubTree = indexInInorder - left;

        root.left = buildTree(preorder, inorder, indexMap, rootIndex+1, left, indexInInorder-1);
        System.out.println(rootIndex+sizeOfLeftSubTree+1+" ");
        root.right = buildTree(preorder, inorder, indexMap, rootIndex+sizeOfLeftSubTree+1, indexInInorder+1, right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for(int i = 0; i<inorder.length; i++){
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, indexMap, 0, 0, preorder.length-1);
    }
}
