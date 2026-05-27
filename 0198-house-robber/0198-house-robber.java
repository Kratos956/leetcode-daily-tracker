class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length+2];
        Arrays.fill(dp,-1);
        generate(0,nums,0,dp);
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