class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> temp=new ArrayList<>();

        Inorder(root,temp);
        for(int i=1;i<temp.size();i++){
            if(temp.get(i-1)>=temp.get(i)) return false;
        }
        return true;

    }
    void Inorder(TreeNode node,List<Integer> temp){
        if(node==null) return;

        Inorder(node.left,temp);
        temp.add(node.val);
        Inorder(node.right,temp);

    }
}