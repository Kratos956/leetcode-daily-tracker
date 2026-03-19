class Solution {

    class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode root) {
        // base case
        if (root == null) {
            return new Pair(null, 0);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        // Case 1: left deeper
        if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        }

        // Case 2: right deeper
        if (right.depth > left.depth) {
            return new Pair(right.node, right.depth + 1);
        }

        // Case 3: equal depth → current node is LCA
        return new Pair(root, left.depth + 1);
    }
}