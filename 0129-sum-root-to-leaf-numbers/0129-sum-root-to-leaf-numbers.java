class Solution {
    public int sumNumbers(TreeNode root) {
        return generate(root,0);

    }
    int generate(TreeNode root,int sum){
        if(root==null) return 0;

        sum=sum*10+root.val;
        if(root.left==null && root.right==null){
            return sum;
        }
        return generate(root.left,sum)+generate(root.right,sum);
    }
}