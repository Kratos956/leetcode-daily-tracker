class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root,root,k);
    }
    boolean dfs(TreeNode node,TreeNode root,int k){
        if(node==null) return false;
        int target=k-node.val;
        if(target!=node.val && find(root,target)){
            return true;
        }
        return dfs(node.left,root,k) || dfs(node.right,root,k);
    }
    boolean find(TreeNode root, int k) {
        if(root == null) return false;
        if(root.val == k) return true;
        if(root.val < k) return find(root.right, k);
        return find(root.left, k);
    }
}
