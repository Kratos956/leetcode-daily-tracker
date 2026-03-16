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
    boolean isTrue(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null) return true;
        if(node1==null || node2==null) return false;
        if(node1.val!=node2.val) return false;
        boolean Left=isTrue(node1.left,node2.left);
        boolean Right=isTrue(node1.right,node2.right);
        return Left&&Right;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(root.val==subRoot.val && isTrue(root,subRoot)){
            return true;
        }
        boolean L=isSubtree(root.left,subRoot);
        boolean R=isSubtree(root.right,subRoot);
        return L || R;
    }

}