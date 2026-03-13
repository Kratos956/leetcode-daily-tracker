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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelsize=q.size();
            List<Integer> arr=new ArrayList<>();
            while(levelsize>0){
                TreeNode t=q.poll();
                
                if(t.left!=null) q.offer(t.left);
                if(t.right!=null) q.offer(t.right);
                arr.add(t.val);
                levelsize--;  
            }
            res.add(arr);

        }
        return res.reversed();
    }
}