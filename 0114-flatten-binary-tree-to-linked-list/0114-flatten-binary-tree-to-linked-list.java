class Pair {
    TreeNode head;
    TreeNode tail;

    Pair(TreeNode head, TreeNode tail) {
        this.head = head;
        this.tail = tail;
    }
}

class Solution {

    public void flatten(TreeNode root) {
        dfs(root);
    }

    Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(null, null);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        root.left = null;

        // Leaf
        if (left.head == null && right.head == null) {
            return new Pair(root, root);
        }

        // Only right subtree
        if (left.head == null) {
            root.right = right.head;
            return new Pair(root, right.tail);
        }

        // Only left subtree
        if (right.head == null) {
            root.right = left.head;
            return new Pair(root, left.tail);
        }

        // Both exist
        root.right = left.head;
        left.tail.right = right.head;

        return new Pair(root, right.tail);
    }
}