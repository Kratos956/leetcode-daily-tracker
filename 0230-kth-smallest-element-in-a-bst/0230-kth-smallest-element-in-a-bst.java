class Solution {
    int ans=0;
    public int kthSmallest(TreeNode root, int k) {
        int[] res=new int[1];
        inorder(root, k,res);
        return res[0];
    }
    void inorder(TreeNode root,int k,int[] res){
        if(root == null) return;

        inorder(root.left,k,res);
        ans=ans+1;
        if(ans==k) {
            res[0]=root.val;
            return;
        }
        inorder(root.right,k,res);

    }
}