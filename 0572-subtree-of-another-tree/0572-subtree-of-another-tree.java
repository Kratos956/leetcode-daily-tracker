class Solution {
    boolean isSubtree=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }
    

    boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        boolean leftSubtree=isSameTree(p.left,q.left);
        boolean rightSubtree=isSameTree(p.right,q.right);
        return leftSubtree && rightSubtree;
    }
}