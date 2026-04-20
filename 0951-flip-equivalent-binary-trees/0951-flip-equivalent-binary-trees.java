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
    public boolean flipEquiv(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;

        boolean left=flipEquiv(p.left,q.left);
        boolean right=flipEquiv(p.right,q.right);

        boolean flipLeft=flipEquiv(p.left,q.right);
        boolean flipRight=flipEquiv(p.right,q.left);

        return (left && right) || (flipLeft && flipRight);
    }
}