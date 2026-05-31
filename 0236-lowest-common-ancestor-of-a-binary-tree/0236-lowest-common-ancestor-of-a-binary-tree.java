class Solution {
    TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        generate(root,p,q);
        return ans;
    }
    int generate(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return 0;


        int left=generate(root.left,  p,  q);
        int right=generate(root.right,  p,  q);

        int self=0;
        if(root.val==p.val || root.val==q.val) self=1;

        int total=self+left+right;
        if(total==2 && ans==null){
            ans=root;
        }

        return total;
        
    }
}