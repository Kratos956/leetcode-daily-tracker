class Pair {
    int first, second;   // first = value, second = distance
    Pair(int a, int b){
        first = a;
        second = b;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.second != b.second)
                    return a.second - b.second;
                return a.first - b.first;
            }
        );

        for (int num : arr) {
            pq.offer(new Pair(num, Math.abs(num - x)));
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(pq.poll().first);
        }

        Collections.sort(list);
        return list;
    }
}