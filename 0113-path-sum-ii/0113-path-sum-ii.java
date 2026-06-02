/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        generate(root,targetSum,res,temp);
        return res;
    }
    void generate(TreeNode root, int targetSum,List<List<Integer>> res,List<Integer> temp){
        if(root==null) return;
        temp.add(root.val);
        if(root.left==null && root.right==null){
            int sum=0;
            for(int i=0;i<temp.size();i++){
                sum+=temp.get(i);
            }
            if(sum==targetSum) res.add(new ArrayList<>(temp));
        }

        generate(root.left,targetSum,res,temp);
        generate(root.right,targetSum,res,temp);
        temp.remove(temp.size()-1);
    }
}