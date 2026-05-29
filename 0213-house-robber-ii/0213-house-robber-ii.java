class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n=nums.length;
        int first=0;
        int second=0;
        for(int i=n-2;i>=0;i--){
            int result=Math.max(nums[i]+second,first);
            second=first;
            first=result;
        }

        int third=0;
        int fourth=0;
        for(int i=n-1;i>=1;i--){
            int result=Math.max(nums[i]+fourth,third);
            fourth=third;
            third=result;
        }
        return Math.max(first,third);
    }
}