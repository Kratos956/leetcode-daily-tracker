class Solution {
    TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val) generate(root,q,p);
        generate(root,p,q);
        return ans;
    }
    void generate(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return;

        if(p.val<=root.val && q.val>=root.val){
            ans=root;
            return;
        }
        if(p.val<root.val && q.val<root.val){
            generate(root.left,p,q);
        }
        if(p.val>root.val && q.val>root.val){
            generate(root.right,p,q);
        }
    }
}