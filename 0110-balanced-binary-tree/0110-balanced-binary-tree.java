class Solution {
    boolean ans=true;
    public boolean isBalanced(TreeNode root) {
        generate(root);
        return ans;

    }
    int generate(TreeNode node){
        if(node==null) return 0;
        int left = generate(node.left);
        int right = generate(node.right);
        if(Math.abs(left-right)>1){
            ans=false;
        }
        return Math.max(left,right)+1;

    }
}