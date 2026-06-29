class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] degree=new int[n];
        for(int[] relation:relations){
            int u=relation[0];
            int v=relation[1];
            adj.get(u-1).add(v-1);
            degree[v-1]++;
        }
        int[] CT=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<degree.length;i++){
            if(degree[i]==0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int u=q.poll();
            for(int ele:adj.get(u)){
                degree[ele]--;
                if(degree[ele]==0) q.add(ele);
                CT[ele]=Math.max(CT[ele],time[u]+CT[u]);
            }
        }
        int ans=0;
        for(int i=0;i<CT.length;i++){
            ans=Math.max(ans,CT[i]+time[i]);
        }
        System.out.println(Arrays.toString(CT));
        return ans;
    }
}