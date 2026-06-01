class Solution {
    TreeNode prev=null;
    List<TreeNode> list=new ArrayList<>();
    public void recoverTree(TreeNode root) {
        Inorder(root);
        TreeNode first=list.get(0);
        TreeNode second=list.get(list.size()-1);

        int temp=second.val;
        second.val=first.val;
        first.val=temp;


    }
    void Inorder(TreeNode node){
        if(node==null) return;

        Inorder(node.left);
        if(prev==null){
            prev=node;
        }
        else{
            if(node.val<=prev.val){
                list.add(prev);
                list.add(node);

            }
            prev=node;
        }
        Inorder(node.right);

    }
}