class Solution {
    public int sumNumbers(TreeNode root) {
        List<String> res = new ArrayList<>();

        generate(root, new StringBuilder(),res);
        int sum = 0;
        for(String s: res){
            sum += Integer.parseInt(s);
        }
        return sum;

    }
    void generate(TreeNode root,StringBuilder sb,List<String> res){
        if(root==null) return ;

        sb.append(root.val);
        if(root.left==null && root.right==null){
            res.add(sb.toString());
        }
        generate(root.left,sb,res);
        generate(root.right,sb,res);
        sb.deleteCharAt(sb.length()-1);

    }
}