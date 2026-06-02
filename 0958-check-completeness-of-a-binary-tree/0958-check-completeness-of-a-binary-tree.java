class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean nullSeen=false;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                nullSeen=true;
            } else  {
                if(nullSeen){
                    return false;
                }
                q.add(node.left);
                q.add(node.right);
            }

        }
        return true;


    }
}