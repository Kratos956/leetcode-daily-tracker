class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<relations.length;i++){
            int u = relations[i][0];
            int v = relations[i][1];
            adj.get(u-1).add(v-1);
        }
        int[] degree = new int[n];
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                degree[adj.get(i).get(j)]++;
            }
        }
        int[] CT= new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<degree.length;i++){
            if(degree[i]==0){
                q.offer(i);
            }
        }
        generated(adj,time,degree,CT,q);
        int ans=0;
        for(int i=0;i<CT.length;i++){
            CT[i]=CT[i]+time[i];
            ans=Math.max(ans,CT[i]);
        }
        return ans;

    }
    void generated(List<List<Integer>> adj,int[] time,int[] degree,int[] CT,Queue<Integer> q){
        while(!q.isEmpty()){
            int u=q.poll();
            for(int i=0;i<adj.get(u).size();i++){
                degree[adj.get(u).get(i)]--;
                CT[adj.get(u).get(i)]=Math.max(CT[adj.get(u).get(i)],CT[u]+time[u]);
                if(degree[adj.get(u).get(i)]==0){
                    q.offer(adj.get(u).get(i));
                }
            }
        }
    }
}