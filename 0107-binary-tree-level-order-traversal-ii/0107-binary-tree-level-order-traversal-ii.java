class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                
                temp.add(curr.val);

                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }

            res.addFirst(new ArrayList<>(temp));
        }
        return res;
    }
}