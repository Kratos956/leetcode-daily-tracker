class Solution {
    public boolean isCompleteTree(TreeNode root) {
        List<Integer> temp=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            
            int n=q.size();
            for(int i=0;i<n;i++) {
                TreeNode u = q.poll();
                temp.add(u.val);
                if (u.val == 0) continue;

                if (u.left == null) q.add(new TreeNode(0));
                if (u.left != null) q.add(u.left);
                if (u.right == null) q.add(new TreeNode(0));
                if (u.right != null) q.add(u.right);

            }
        }
        System.out.println(temp);

        
        boolean nowZero=true;
        for(int i=temp.size()-1;i>=0;i--){
            if(temp.get(i)==0 && !nowZero){
                return false;
            } else if (temp.get(i)!=0) {
                nowZero=false;
            }
        }
        return true;


    }
}