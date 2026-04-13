class Solution {
    int count=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] discovery = new int[n];
        int[] low = new int[n];
        int[] visited = new int[n];

        List<List<Integer>> Bridges = new ArrayList<>();

        generated(0,-1, adj, discovery, low, visited, Bridges);
        return Bridges;
    }
    void generated(int node,int parent,List<List<Integer>> adj,int[] discovery, int[] low, int[] visited, List<List<Integer>> Bridges){
        visited[node]=1;
        discovery[node] = low[node]=count++;
        for(int i=0;i<adj.get(node).size();i++){
            int nei=adj.get(node).get(i);
            if(nei==parent){
                continue;
            }
            if(visited[nei]==1){
                low[node] = Math.min(low[node], low[nei]);
            }
            else{
                generated(nei, node, adj, discovery, low, visited, Bridges);
                low[node]=Math.min(low[node],low[nei]);
                if(low[nei]>discovery[node]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nei);
                    temp.add(node);
                    Bridges.add(temp);
                }
            }
        }

    }
}