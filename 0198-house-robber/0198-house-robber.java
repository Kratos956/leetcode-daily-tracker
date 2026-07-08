class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n-1==0) return nums[0];
        if(n-1==1) return Math.max(nums[0],nums[1]);
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);

        for(int i=2;i<n;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

        return dp[n-1];
    }
    int find(int n,int[] nums,int[] dp){
        if(n==0) return nums[0];
        if(n==1) return Math.max(nums[0],nums[1]);

        if(dp[n]!=-1) return dp[n];

        return dp[n] = Math.max(nums[n]+find(n-2,nums,dp),find(n-1,nums,dp));
    }

}