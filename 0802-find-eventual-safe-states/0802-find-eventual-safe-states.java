class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adj=new ArrayList<>();
        int[] degree=new int[n];
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
                degree[i]++;
            }
        }
        System.out.println(adj);
        System.out.println(Arrays.toString(degree));
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==0) q.add(i);
        }
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int u=q.poll();
            res.add(u);
            for(int ele:adj.get(u)){
                degree[ele]--;
                if(degree[ele]==0) q.add(ele);
            }
        }
        Collections.sort(res);
        return res;
    }
}