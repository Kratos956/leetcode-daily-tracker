class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root = delete(root);
        }
        return root;
    }

    TreeNode delete(TreeNode node) {
        if (node.left == null && node.right == null)
            return null; // 0 CHILD

        if (node.left == null)
            return node.right; // 1 CHILD
        if (node.right == null)
            return node.left;

        TreeNode InorderSuccessor = find(node.right); // 2 CHILD
        node.val = InorderSuccessor.val;
        node.right = deleteNode(node.right, InorderSuccessor.val); // Now we have to delete the inOrderSuccessor node so we call deletNode function for this also.

        return node;

    }

    TreeNode find(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return find(node.left);

    }
}