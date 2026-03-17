class Solution {
    TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x=p.val;
        int y=q.val;
        if(y<x){
            generate(root,q,p);
        }
        generate(root,p,q);
        return ans;
    }
    void generate(TreeNode root, TreeNode p, TreeNode q){
        if(root.val==p.val || root.val==q.val){
            ans=root;
        }
        if(root.val>p.val && root.val>q.val){
            generate(root.left,p,q);
        }
        if(root.val<p.val && root.val<q.val){
            generate(root.right,p,q);
        }
        if(root.val>p.val && root.val<q.val){
            ans=root;
        }
    }
}