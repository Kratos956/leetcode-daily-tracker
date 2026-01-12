class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int idx=0;
        int arr[]=new int[nums.length-k+1];
        int i=0;
        while(i<k){
            if(i>0){
                while(!deque.isEmpty() && nums[i]>nums[deque.peekLast()]){
                    deque.removeLast();
                }
            }
            deque.addLast(i);
            i++;
        }
        arr[idx++]=nums[deque.peekFirst()];
        int left=0;
        int right=k;
        while(right<nums.length){
            if(!deque.isEmpty() && deque.peekFirst()<left+1){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]){
                deque.removeLast();
            }
            deque.addLast(right);
            arr[idx++]=nums[deque.peekFirst()];
            left++;
            right++;
        }
        return arr;

    }
}