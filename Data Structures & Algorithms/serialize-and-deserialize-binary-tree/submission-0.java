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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(sb.length() > 0) sb.append(',');
            if(node == null){
                 sb.append('n');
            } else{
                sb.append(node.val) ;
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        String[]parts = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        queue.add(root);

        int i = 1;
        while(!queue.isEmpty() && i < parts.length){
            TreeNode parent = queue.poll();
            
            if(i < parts.length && !parts[i].equals("n")){
                TreeNode curr = new TreeNode(Integer.parseInt(parts[i]));
                queue.add(curr);
                parent.left = curr;
            }
            i++;

            if(i < parts.length && !parts[i].equals("n")){
                TreeNode curr = new TreeNode(Integer.parseInt(parts[i]));
                queue.add(curr);
                parent.right = curr;
            }
            i++;
        }

        return root;
    }
}
