class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean[] visited=new boolean[n];
        boolean[] path=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,graph,visited,path);
            }
        }
        System.out.println(Arrays.toString(path));
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!path[i]) res.add(i);
        }
        return res;

    }
    boolean dfs(int index,int[][] graph,boolean[] visited,boolean[] path){
        visited[index]=true;
        path[index]=true;
        for(int ele:graph[index]){
            if(path[ele]) return true;
            if(visited[ele]) continue;
            if(dfs(ele,graph,visited,path)) return true;
        }
        path[index]=false;
        return false;
    }
}