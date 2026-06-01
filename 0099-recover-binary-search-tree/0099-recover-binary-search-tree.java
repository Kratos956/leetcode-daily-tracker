class Solution {
    TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        Inorder(root,list);
        TreeNode first=list.get(0);
        TreeNode second=list.get(list.size()-1);

        int temp=second.val;
        second.val=first.val;
        first.val=temp;


    }
    void Inorder(TreeNode node,List<TreeNode> list){
        if(node==null) return;

        Inorder(node.left,list);
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
        Inorder(node.right,list);

    }
}