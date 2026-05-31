class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return null;
        }

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else{
            return delete(root);
        }

        return root;
    }

    TreeNode delete(TreeNode node){

        // 0 child
        if(node.left == null && node.right == null){
            return null;
        }

        // 1 child
        if(node.left == null){
            return node.right;
        }

        // 1 child
        if(node.right == null){
            return node.left;
        }

        // 2 children
        TreeNode inorderSuccessor = find(node.right);

        node.val = inorderSuccessor.val;

        node.right = deleteNode(node.right, inorderSuccessor.val);

        return node;
    }

    TreeNode find(TreeNode node){

        if(node.left == null){
            return node;
        }

        return find(node.left);
    }
}