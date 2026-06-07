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
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> stk=new Stack<>();
        stk.add(root);
        while(!stk.isEmpty()){
            TreeNode u=stk.pop();
            ans.add(u.val);
            if(u.right!=null) stk.add(u.right);
            if(u.left!=null) stk.add(u.left);
        }
        return ans;
    }
}