class Codec {
    int index=0;


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "null ";
        String s= root.val + " ";
        s=s+serialize(root.left)+serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(" ");
        return generate(split);
    }
    TreeNode generate(String[] split){
        
        if(split[index].equals("null")){
            index++;
            return null;
        }
        
        TreeNode root=new TreeNode(Integer.parseInt(split[index]));
        index++;
        
        
        root.left=generate(split);
        root.right=generate(split);
        return root;
    }
}