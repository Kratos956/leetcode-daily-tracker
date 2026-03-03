class Pair{
    int first, second;
    Pair(int a, int b){
        first = a;
        second = b;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b)->{
                    if(Math.abs(a.first-x)==Math.abs(b.first-x)){
                        return a.first-b.first;
                    }
                    else{
                        return a.second-b.second;
                    }
                }
        );
        for(int i=0;i<arr.length;i++){
            pq.offer(new Pair(arr[i],Math.abs(arr[i]-x)));

        }
        List<Integer> list = new ArrayList<>();
        int count=0;
        while(!pq.isEmpty() && count<k){
            Pair p = pq.poll();
            list.add(p.first);
            count++;
        }
        Collections.sort(list);
        return list;
    }
}