class Solution {
    boolean isSubtree=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null) return false;
        Preorder(root, subRoot);
        return isSubtree;
    }
    void Preorder(TreeNode root,TreeNode subRoot) {
        if(root==null) return;
        if(root.val==subRoot.val && sameTree(root,subRoot)){
            isSubtree=true;
        }
        Preorder(root.left, subRoot);
        Preorder(root.right, subRoot);
    }

    boolean sameTree(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        boolean leftSubtree=sameTree(p.left,q.left);
        boolean rightSubtree=sameTree(p.right,q.right);
        return leftSubtree && rightSubtree;
    }
}