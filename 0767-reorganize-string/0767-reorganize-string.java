class Pair{
    Character first;
    int second;
    Pair(Character a,int b){
        first=a;
        second=b;
    }
}
class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(
                (a,b)->{return b.second-a.second;}
        );

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(result.isEmpty() || result.charAt(result.length()-1)!=p.first){
                result.append(p.first);
                p.second=p.second-1;
                if(p.second>0){
                    pq.add(p);
                }
            }
            else{
                if(pq.isEmpty()){
                    return "";
                }
                Pair p2=pq.poll();
                result.append(p2.first);
                p2.second=p2.second-1;
                if(p2.second>0){
                    pq.add(p2);
                }
                pq.add(p);
            }

        }
        return result.toString();

    }
}