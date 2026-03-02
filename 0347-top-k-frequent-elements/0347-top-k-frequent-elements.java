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

        int[] arr =new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.second)
        );
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int count = 0;
        while(!pq.isEmpty() && count < k){
            Pair p = pq.poll();
            arr[count++]=p.first;
        }
        return arr;
    }
}
