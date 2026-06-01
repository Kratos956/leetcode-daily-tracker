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
            prev=new TreeNode(node.val);
        }
        else{
            if(node.val<=prev.val){
                ans=false;
                return;
            }
            prev=new TreeNode(node.val);
        }
        Inorder(node.right);

    }
}