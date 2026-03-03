class Pair{
    int[] first;
    int second;
    Pair(int[] a,int b){
        first=a;
        second=b;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<int[], Integer> map = new HashMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            map.put(point, ( x * x  +  y * y));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b)->{
                    return Math.toIntExact((b.second - a.second));
                }
        );
        for(Map.Entry<int[],Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        int index = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ans[index++]=p.first;
        }
        return ans;


    }
}