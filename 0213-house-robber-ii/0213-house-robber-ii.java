class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int[] dp1=new int[3];
        int[] dp2=new int[3];
        dp1[1]=nums[n-2];
        dp1[0]=Math.max(nums[n-3],nums[n-2]);
        for(int i=n-4;i>=0;i--){

            dp1[2]=dp1[1];
            dp1[1]=dp1[0];

            dp1[0]=Math.max(nums[i]+dp1[2],dp1[1]);
        }

        dp2[1]=nums[n-1];
        dp2[0]=Math.max(nums[n-1],nums[n-2]);
        for(int j=n-3;j>0;j--){
            dp2[2]=dp2[1];
            dp2[1]=dp2[0];
            dp2[0]=Math.max(nums[j]+dp2[2],dp2[1]);
        }


        return Math.max(dp1[0],dp2[0]);
    }
}