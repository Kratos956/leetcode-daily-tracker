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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> temp=new ArrayList<>();
        generate(root,temp);
        return temp;
    }
    void generate(TreeNode root,List<Integer> temp){
        if(root==null){
            return;
        }
        temp.add(root.val);
        generate(root.left,temp);
        generate(root.right,temp);
    }
}