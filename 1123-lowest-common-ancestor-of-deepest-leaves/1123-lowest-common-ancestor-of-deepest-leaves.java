class Pair{
    int height;
    TreeNode LCA;
    Pair(int height, TreeNode LCA) {
        this.height = height;
        this.LCA = LCA;
    }
}
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair pair = generate(root);
        return pair.LCA;
    }
    Pair generate(TreeNode root) {

        if(root == null) return new Pair(0,null);


        Pair left=generate(root.left);
        Pair right=generate(root.right);

        if(left.height==right.height){
            return new Pair(left.height+1,root);
        }
        if(left.height<right.height){
            return new Pair(right.height+1,right.LCA);
        }
        else {
            return new Pair(left.height+1,left.LCA);
        }
        

    }
}