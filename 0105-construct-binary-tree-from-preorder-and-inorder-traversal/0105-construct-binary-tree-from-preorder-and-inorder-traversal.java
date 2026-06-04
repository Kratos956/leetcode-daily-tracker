class Solution {
    int index=0;
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return generate(0,inorder.length-1,preorder,inorder);

    }
    TreeNode generate(int i,int j,int[] preorder,int[] inorder){
        if(i>j) return null;
        TreeNode root=new TreeNode(preorder[index]);
        index++;


        int x=map.get(root.val);
        root.left=generate(i,x-1,preorder,inorder);
        root.right=generate(x+1,j,preorder,inorder);
        return root;

    }

}