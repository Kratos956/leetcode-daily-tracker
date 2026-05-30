class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.val==subRoot.val && isSameTree(node, subRoot)){
                return true;
            }
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return false;
    }
//    void inorder(TreeNode root,TreeNode subroot,boolean isSubtree){
//        if(root==null) return;
//        if(root.val==subroot.val && isSameTree(root,subroot)){
//            isSubtree=true;
//        }
//        if(!isSubtree){
//            inorder(root.left,subroot,isSubtree);
//            inorder(root.right,subroot,isSubtree);
//        }
//    }
    boolean isSameTree(TreeNode r1,TreeNode r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null) return false;
        if(r1.val!=r2.val) return false;
        boolean l=isSameTree(r1.left,r2.left);
        boolean r=isSameTree(r1.right,r2.right);
        return l && r;
    }
}