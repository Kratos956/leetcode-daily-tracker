class Solution {
    List<Integer> list;
    TreeNode ans=null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();List<Integer> temp = new ArrayList<>();q.add(root);temp.add(root.val);
        getHeight(root,q);
        int size=list.size();
        lcaDepth(root,size);
        return ans;



    }
    void getHeight(TreeNode root,Queue<TreeNode> q) {
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                temp.add(cur.val);

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            list=temp;

        }

    }

    int lcaDepth(TreeNode root,int n){
        if(root==null){
            return 0;
        }
        int left=lcaDepth(root.left,n);
        int right=lcaDepth(root.right,n);
        int self=0;
        if(list.contains(root.val)){
            self=1;
        }
        int total=left+right+self;
        if(total==n && ans==null){
            ans=root;

        }
        return total;
    }
}