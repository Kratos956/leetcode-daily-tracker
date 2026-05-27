class Solution {
    public int rob(int[] nums) {
        int first=0;
        int second=0;
        int result=0;
        for(int i=nums.length-1;i>=0;i--){
            result=Math.max(nums[i]+second,first);
            second=first;
            first=result;
        }
        return result;

    }
}