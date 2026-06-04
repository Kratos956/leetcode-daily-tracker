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
    public void flatten(TreeNode root) {
        if(root == null) return;

        List<Integer> temp = new ArrayList<>();
        preorder(root, temp);

        TreeNode curr = root;

        for(int i = 1; i < temp.size(); i++){
            curr.left = null;
            curr.right = new TreeNode(temp.get(i));
            curr = curr.right;
        }

        curr.left = null;
    }
    void preorder(TreeNode root,List<Integer> temp){
        if(root == null) return ;
        temp.add(root.val);
        preorder(root.left,temp);
        preorder(root.right,temp);

    }
}