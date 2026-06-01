class Solution {
    TreeNode prev=null;
    boolean ans=true;
    public boolean isValidBST(TreeNode root) {
        Inorder(root);
        return ans;
    }
    void Inorder(TreeNode node){
        if(node==null) return;

        Inorder(node.left);
        if(prev==null){
            prev=node;
        }
        else{
            if(node.val<=prev.val){
                ans=false;
                return;
            }
            prev=node;
        }
        Inorder(node.right);

    }
}