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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int bool=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();

            while(size>0){
                TreeNode node=queue.remove();
                if(bool==0){
                    temp.add(node.val);
                }else{
                    temp.addFirst(node.val);
                }

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                size--;

            }
            res.add(new ArrayList<>(temp));
            bool=1-bool;
        }
        return res;
    }
}