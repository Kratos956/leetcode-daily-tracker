class Solution {
    int res=0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> map=new HashMap<>();
        map.put(0L,1);
        generate(root,targetSum,map, 0L);
        return res;
    }
    void generate(TreeNode root,int target,Map<Long,Integer> map,Long sum){
        if(root==null) return;
        sum=sum+root.val;
        if(map.containsKey(sum-target)) res=res+map.get(sum-target);
        map.put(sum,map.getOrDefault(sum,0)+1);

        generate(root.left,target,map,sum);
        generate(root.right,target,map,sum);

        map.put(sum,map.get(sum)-1);
        if(map.get(sum)==0) map.remove(sum);
    }
}