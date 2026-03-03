class Pair{
    int first, second;
    Pair(int a, int b){
        first = a;
        second = b;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b)->{
                    if(a.first == b.first){
                        return a.second-b.second;
                    }
                    else{
                        return a.first-b.first;
                    }
                }
        );
        for(int i = 0; i < mat.length; i++){
            int low=0;
            int high=mat[i].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(mat[i][mid]==1){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            
            pq.offer(new Pair(low,i));

        }
        int[] res = new int[k];
        int count=0;
        while(count<k){
            res[count++]=pq.poll().second;
        }
        return res;
    }
}