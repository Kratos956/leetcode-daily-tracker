class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode u1=q.poll();
            TreeNode u2=q.poll();
            if (u1 == null && u2 == null) continue;
            if (u1 == null || u2 == null) return false;
            if (u1.val != u2.val) return false;
            
            q.offer(u1.left);
            q.offer(u2.right);
            q.offer(u1.right);
            q.offer(u2.left);
        }
        return true;
    }

}