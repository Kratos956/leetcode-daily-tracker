class Pair{
    int capital;
    int profit;

    Pair(int capital, int profit){
        this.capital = capital;
        this.profit = profit;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        Pair[] pairs = new Pair[profits.length];

        for(int i=0;i<profits.length;i++){
            pairs[i] = new Pair(capital[i], profits[i]);
        }

        Arrays.sort(pairs, (a,b) -> a.capital - b.capital);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int idx = 0;

        while(k > 0){

            while(idx < pairs.length && pairs[idx].capital <= w){
                pq.add(pairs[idx].profit);
                idx++;
            }

            if(pq.isEmpty()){
                break;
            }

            w += pq.poll();
            k--;
        }

        return w;
    }
}