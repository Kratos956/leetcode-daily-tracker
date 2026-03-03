class Pair{
    String first;
    int second;
    Pair(String a,int b){
        first=a;
        second=b;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b)->{
                    if(a.second!=b.second){
                        return b.second-a.second;
                    }
                    else{
                        return a.first.compareTo(b.first);
                    }
                }
        );
        for (String word : map.keySet()) {
            pq.offer(new Pair(word, map.get(word)));

        }
        int count=0;
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty() && count<k){
            Pair p = pq.poll();
            res.add(p.first);
            count++;
        }
        return res;
    }
}
