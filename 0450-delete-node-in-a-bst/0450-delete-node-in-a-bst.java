class Solution {
    TreeNode inScr(TreeNode curr){
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else{
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode successor=inScr(root);
            root.val=successor.val;
            root.right=deleteNode(root.right,successor.val);
        }
        return root;
    }

}