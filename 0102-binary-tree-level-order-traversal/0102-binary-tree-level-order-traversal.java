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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) {
            return list;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                if(queue.peek().left!=null) queue.add(queue.peek().left);
                if(queue.peek().right!=null) queue.add(queue.peek().right);
                temp.add(queue.remove().val);
            }
            list.add(new ArrayList<>(temp));
        }
        return list;

    }
    
}