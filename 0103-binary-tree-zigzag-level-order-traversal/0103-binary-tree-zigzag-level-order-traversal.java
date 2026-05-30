class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;

        int change=0;
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                
                if(change==0){
                    temp.add(curr.val);
                }
                else{
                    temp.addFirst(curr.val);
                }

                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }

            res.add(new ArrayList<>(temp));
            change=1-change;
        }
        return res;
    }
}