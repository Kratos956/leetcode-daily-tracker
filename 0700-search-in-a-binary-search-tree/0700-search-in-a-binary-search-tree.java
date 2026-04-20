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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) return root;
        TreeNode nodeLeft = null;
        TreeNode nodeRight = null;
        if (root.left != null && val < root.val) {
            nodeLeft = searchBST(root.left, val);
        } else if (root.right != null && val > root.val) {
            nodeRight = searchBST(root.right, val);
        }
        if (nodeLeft != null) return nodeLeft;
        if (nodeRight != null) return nodeRight;
        return null;

    }
}