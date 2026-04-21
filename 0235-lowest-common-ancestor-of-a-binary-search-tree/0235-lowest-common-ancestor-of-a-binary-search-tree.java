/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x=p.val;
        int y=q.val;
        if(y<x){
            return generate(root,q,p);
        }
        return generate(root,p,q);
        
        
    }
    TreeNode generate(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;

        if(p.val<=root.val && root.val<=q.val){
            return root;
        }
        else if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return lowestCommonAncestor(root.left,p,q);
    }
}