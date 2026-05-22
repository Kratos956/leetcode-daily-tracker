class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int min_length=Integer.MAX_VALUE;
        int x=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum<target) continue;
            while(sum>=target){
                min_length=Math.min(min_length,i-x+1);
                sum=sum-nums[x];
                x++;
            }
        }
        return min_length == Integer.MAX_VALUE ? 0 : min_length;
    }
}