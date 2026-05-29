class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp1=new int[nums.length+1];
        Arrays.fill(dp1,-1);
        int[] dp2=new int[nums.length+2];
        Arrays.fill(dp2,-1);
        generate(0,nums,0,nums.length-2,dp1);
        generate(1,nums,0,nums.length-1,dp2);
        return Math.max(dp1[0],dp2[1]);

    }
    int generate(int i,int[] nums,int sum,int n,int[] dp){
        if(i>=n+1) return 0;

        if(dp[i]!=-1) return dp[i];

        dp[i]=Math.max((nums[i]+generate(i+2,nums,sum+nums[i],n,dp)),generate(i+1,nums,sum,n,dp));

        return dp[i];
    }
}