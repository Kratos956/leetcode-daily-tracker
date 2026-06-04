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
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return generate(0,inorder.length-1,preorder,inorder);
        
    }
    TreeNode generate(int i,int j,int[] preorder,int[] inorder){
        if(i>j) return null;
        TreeNode root=new TreeNode(preorder[index]);
        index++;

        
        for(int x=i;x<=j;x++){
            if(inorder[x]==root.val){
                root.left=generate(i,x-1,preorder,inorder);
                root.right=generate(x+1,j,preorder,inorder);
                break;
            }
        }
        return root;

    } 

}