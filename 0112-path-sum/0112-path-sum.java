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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return PathSum(root,targetSum,0);
    }
    boolean PathSum(TreeNode root, int targetSum,int sum){
        if(root==null) return false;
        sum+=root.val;

        if(root.left==null && root.right==null){
            if(sum==targetSum) return true;
            return false;
        }
        boolean left=PathSum(root.left,targetSum,sum);
        boolean right=PathSum(root.right,targetSum,sum);
        return left || right;
    }
}