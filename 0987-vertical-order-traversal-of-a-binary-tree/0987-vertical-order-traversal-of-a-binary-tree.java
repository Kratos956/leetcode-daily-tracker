class Pair{
    TreeNode node;
    int Level;
    int Vertical;
    Pair(TreeNode node,int Level,int Vertical) {
        this.node = node;
        this.Level = Level;
        this.Vertical = Vertical;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b)-> {
                    if(a.Vertical!=b.Vertical) return Integer.compare(a.Vertical, b.Vertical);
                    else if (a.Level!=b.Level) {
                        return Integer.compare(a.Level, b.Level);
                    }
                    return Integer.compare(a.node.val, b.node.val);
                }
        );

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0,0));
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            Pair u=q.poll();
            min=Math.min(min,u.Vertical);
            max=Math.max(max,u.Vertical);
            pq.add(u);
            if(u.node.left!=null){
                q.add(new Pair(u.node.left,u.Level+1,u.Vertical-1));
            }
            if(u.node.right!=null){
                q.add(new Pair(u.node.right,u.Level+1,u.Vertical+1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<(max-min+1);i++){
            res.add(new ArrayList<>());
        }
        int level=Math.abs(min);
        while(!pq.isEmpty()){
            Pair u=pq.poll();
            res.get(level+u.Vertical).add(u.node.val);
        }
        return res;
    }
}