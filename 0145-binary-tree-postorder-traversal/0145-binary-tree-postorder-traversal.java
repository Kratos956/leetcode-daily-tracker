class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> stk=new Stack<>();
        stk.add(root);
        while(!stk.isEmpty()){
            TreeNode u=stk.pop();
            ans.add(u.val);
            if(u.left!=null) stk.add(u.left);
            if(u.right!=null) stk.add(u.right);
        }
        return ans.reversed();
    }
}