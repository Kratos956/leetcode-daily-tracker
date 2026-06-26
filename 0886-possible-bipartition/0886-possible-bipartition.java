class Solution {
    public boolean possibleBipartition(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u-1).add(v-1);
            adj.get(v-1).add(u-1);
        }
        System.out.println(Arrays.deepToString(adj.toArray()));
        int[] colour=new int[n];
        Arrays.fill(colour,-1);
        for(int i=0;i<n-1;i++){
            if(colour[i]==-1 && !DFS(i,-1,colour,adj)){
                return false;
            }
        }
        return true;
    }
    boolean DFS(int index,int parent,int[] colour,List<List<Integer>> adj){
        if(parent!=-1){
            colour[index]=1-colour[parent];
        }
        else{
            colour[index]=0;
        }
        for(int ele:adj.get(index)){
            if(ele==parent) continue;
            if(colour[ele]==colour[index]) return false;
            if(colour[ele]==-1 && !DFS(ele,index,colour,adj)) return false;
        }
        return true;
    }
}