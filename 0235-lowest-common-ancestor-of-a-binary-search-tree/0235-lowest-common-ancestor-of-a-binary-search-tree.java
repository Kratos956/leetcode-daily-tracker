class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val) return generate(root,q,p);
        return generate(root,p,q);
    }
    TreeNode generate(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;

        if(p.val<=root.val && q.val>=root.val){
            return root;
        }
        else if(p.val<root.val && q.val<root.val){
            return generate(root.left,p,q);
        }
        return generate(root.right,p,q);
    }
}