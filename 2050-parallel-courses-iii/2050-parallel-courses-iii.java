class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int[] degree = new int[n];

        for(int[] edge : relations){
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            adj.get(u).add(v);
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // earliest time when a course can START
        int[] startTime = new int[n];

        for(int i = 0; i < n; i++){
            if(degree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){

            int u = q.poll();

            for(int next : adj.get(u)){

                // next can start only after u finishes
                startTime[next] = Math.max(startTime[next],
                                           startTime[u] + time[u]);

                degree[next]--;

                if(degree[next] == 0){
                    q.offer(next);
                }
            }
        }

        int answer = 0;

        for(int i = 0; i < n; i++){
            answer = Math.max(answer, startTime[i] + time[i]);
        }

        return answer;
    }
}