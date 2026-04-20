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
    public boolean isSymmetric(TreeNode root) {
        
        return generate(root.left, root.right);
    }
    boolean generate(TreeNode L, TreeNode R) {
        if (L==null && R==null) return true;
        if (L==null || R==null) return false;
        if(L.val!=R.val) return false;
        boolean left = generate(L.left, R.right);
        boolean right = generate(L.right, R.left);
        return left && right;

    }
}