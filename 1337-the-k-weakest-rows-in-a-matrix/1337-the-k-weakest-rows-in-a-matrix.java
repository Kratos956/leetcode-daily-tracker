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
            int count=0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            pq.offer(new Pair(count,i));

        }
        int[] res = new int[k];
        int count=0;
        while(count<k){
            res[count++]=pq.poll().second;
        }
        return res;
    }
}