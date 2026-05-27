class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[nums.length+2];
        Arrays.fill(dp,-1);
        dp[n]=0;
        dp[n+1]=0;
        for(int i=n-1;i>=0;i--){
            dp[i]=Math.max((nums[i]+dp[i+2]),dp[i+1]);
        }
        return dp[0];

    }
    int generate(int i,int[] nums,int sum,int[] dp){

        if(i>=nums.length) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }

        dp[i]=Math.max((nums[i]+generate(i+2,nums,sum+nums[i],dp)),generate(i+1,nums,sum,dp));
        return dp[i];
    }
}