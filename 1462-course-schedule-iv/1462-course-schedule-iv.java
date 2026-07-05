class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n=numCourses;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] degree=new int[n];
        for(int[] relation:prerequisites){
            int u=relation[0];
            int v=relation[1];
            adj.get(u).add(v);
            degree[v]++;
        }
        List<Set<Integer>> list=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(new HashSet<>());
            if(degree[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int u=q.poll();
            for(int ele:adj.get(u)){
                degree[ele]--;
                list.get(ele).add(u);
                for(int ele2:list.get(u)){
                    list.get(ele).add(ele2);
                }
                if(degree[ele]==0) q.add(ele);
            }
        }
        System.out.println(list);
        List<Boolean> res=new ArrayList<>();
        for(int[] query:queries){
            int u=query[0];
            int v=query[1];
            if(list.get(v).contains(u)) res.add(true);
            else{
                res.add(false);
            }

        }
        return res;


    }
}