class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        long[] prefix = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int left=0;
        int minSize=Integer.MAX_VALUE;
        for(int right=0;right<=nums.length;right++){
            
            while(!deque.isEmpty() && prefix[right]<=prefix[deque.peekLast()]){
                deque.removeLast();
            }
            
            deque.addLast(right);

            while(!deque.isEmpty() && prefix[right]-prefix[deque.peekFirst()]>=k){
                minSize=Math.min(minSize,right-deque.peekFirst());
                deque.removeFirst();
            }
        }
        return minSize==Integer.MAX_VALUE?-1:minSize;
    }
}