class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] degree=new int[n];
        for(int[] relation:relations){
            int u=relation[0]-1;
            int v=relation[1]-1;
            adj.get(u).add(v);
            degree[v]++;
        }
        int[] EST=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int u=q.poll();
            for(int ele:adj.get(u)){
                degree[ele]--;
                EST[ele]=Math.max(EST[ele],EST[u]+time[u]);
                if(degree[ele]==0) q.add(ele);
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<EST.length;i++){
            ans=Math.max(ans,EST[i]+time[i]);
        }
        return ans;
        
    }
}