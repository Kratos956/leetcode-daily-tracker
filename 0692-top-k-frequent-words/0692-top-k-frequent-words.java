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
                        return a.second-b.second;
                    }
                    else{
                        return b.first.compareTo(a.first);
                    }
                }
        );
        for (String word : map.keySet()) {
            pq.offer(new Pair(word, map.get(word)));
            if (pq.size() > k) {
                pq.poll();
            }

        }
        String arr[]=new String[k];
        for(int i=k-1;i>=0;i--){
            arr[i]=pq.poll().first;
        }
        return Arrays.asList(arr);
    }
}