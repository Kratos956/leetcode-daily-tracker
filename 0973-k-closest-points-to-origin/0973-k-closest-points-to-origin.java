class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b)->{
                    return b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1];
                }
        );
        for(int[] point:points){
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        int index = 0;
        while(!pq.isEmpty()){
            ans[index++]=pq.poll();
        }
        return ans;


    }
}