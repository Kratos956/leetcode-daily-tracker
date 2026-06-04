class Solution {
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return generate(0,inorder.length-1,preorder,inorder,map);

    }
    TreeNode generate(int i,int j,int[] preorder,int[] inorder,Map<Integer,Integer> map){
        if(i>j) return null;
        TreeNode root=new TreeNode(preorder[index]);
        index++;


        int x=map.get(root.val);
        root.left=generate(i,x-1,preorder,inorder,map);
        root.right=generate(x+1,j,preorder,inorder,map);
        return root;

    }

}