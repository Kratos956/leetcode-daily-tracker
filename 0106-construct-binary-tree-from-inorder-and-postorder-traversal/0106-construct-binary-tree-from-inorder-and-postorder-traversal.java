class Solution {
    int index=0;
    Map<Integer,Integer> map=new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return generate(0,inorder.length-1,inorder,postorder);
    }
    TreeNode generate(int i,int j,int[] inorder,int[] postorder){
        if(i>j) return null;

        TreeNode root=new TreeNode(postorder[postorder.length-1-index]);
        index++;

        int x=map.get(root.val);
        root.right=generate(x+1,j,inorder,postorder);
        root.left=generate(i,x-1,inorder,postorder);

        return root;
    }
}