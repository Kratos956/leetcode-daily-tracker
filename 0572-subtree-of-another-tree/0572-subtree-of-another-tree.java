/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null) return false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode u=q.poll();
            if(u.val==subRoot.val && sameTree(u,subRoot)) return true;
            if(u.left!=null) q.add(u.left);
            if(u.right!=null) q.add(u.right);
        }
        return false;
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