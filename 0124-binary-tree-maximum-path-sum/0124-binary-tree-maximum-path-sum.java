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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        gen(root);
        return res;
    }
    int gen(TreeNode root){
        if(root==null) return 0;

        int left=gen(root.left);
        int right=gen(root.right);
        if(left<0){
            left=0;
        }
        if(right<0){
            right=0;
        }
        res=Math.max(res,Math.max(root.val,Math.max(left+right+root.val,Math.max(left+root.val,right+root.val))));

        return Math.max(root.val,Math.max(left+root.val,right+root.val));
    }
}