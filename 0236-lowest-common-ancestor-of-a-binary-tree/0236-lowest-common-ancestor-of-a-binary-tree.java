class Solution {
    TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        generate(root,p,q);
        return ans;

    }
    int generate(TreeNode node, TreeNode p, TreeNode q){
        if(node==null) return 0;
        int L=generate(node.left,p,q);
        int R=generate(node.right,p,q);
        int self=0;
        if(node==p || node==q){
            self=1;
        }
        int total=L+self+R;
        if(total==2 && ans==null){
            ans=node;
        }
        return total;
    }
}