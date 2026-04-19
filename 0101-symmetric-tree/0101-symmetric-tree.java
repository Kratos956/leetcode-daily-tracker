class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        while(!q1.isEmpty()){
            TreeNode u1=q1.poll();
            TreeNode u2=q2.poll();
            if (u1 == null && u2 == null) continue;
            if (u1 == null || u2 == null) return false;
            if (u1.val != u2.val) return false;
            
            q1.offer(u1.left);
            q1.offer(u1.right);
            q2.offer(u2.right);
            q2.offer(u2.left);
        }
        return true;
    }

}