class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int windowSize=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        boolean Find=false;
        while(right<nums.length){
            sum=sum+nums[right];
            if(sum<target){
                right++;
            }
            else if(sum>=target){
                Find=true;
                windowSize=Math.min(windowSize,right-left+1);
                sum=sum-nums[left];
                sum=sum-nums[right];
                left++;
            }
            
        }
        if(Find==false){
            return 0;
        }
        else{
            return windowSize;
        }
    }
}