class Pair{
    int first,second;
    Pair(int a,int b){
        first=a;
        second=b;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b)->{
                    return b.second-a.second;
                }
        );
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
            // if (pq.size() > k) {
            //     pq.poll();
            // }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll().first;
        }
        return res;
    }
}