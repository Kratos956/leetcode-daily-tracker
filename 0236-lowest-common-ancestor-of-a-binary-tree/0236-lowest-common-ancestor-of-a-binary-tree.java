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
    TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        generate(root,p,q);
        return ans;
    }
    int generate(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return 0;
        }
        
        int left=generate(root.left,p,q);
        int right=generate(root.right,p,q);

        int node=0;
        if(root==p || root==q) node=1;
        
        int total=left+node+right;
        if(total==2 && ans==null){
            ans=root;
        }
        
        

        return total;
    }
}