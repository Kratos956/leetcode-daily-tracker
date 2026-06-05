class Pair{
    TreeNode node;
    TreeNode tail;
    Pair(TreeNode node, TreeNode tail) {
        this.node = node;
        this.tail = tail;
    }
}
class Solution {
    public void flatten(TreeNode root) {
        preorder(root);
    }
    Pair preorder(TreeNode root){
        if(root==null){
            return new Pair(null,null);
        }
        

        Pair left=preorder(root.left);
        Pair right=preorder(root.right);

        if(left.node==null && right.node==null){
            root.left=null;
            return new Pair(root,root);
        }
        else if(left.node==null && right.node!=null){
            root.right=right.node;
            root.left=null;
            return new Pair(root,right.tail);
        }
        else if(left.node!=null && right.node==null){
            root.right=left.node;
            root.left=null;
            return new Pair(root,left.tail);
        }
        
        else{
            root.right=left.node;
            left.tail.right=right.node;
            root.left=null;
            return new Pair(root,right.tail);
        }



    }
}