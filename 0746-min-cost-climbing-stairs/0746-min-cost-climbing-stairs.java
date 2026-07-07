class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];

        dp[n]  = 0;
        dp[n-1]= cost[n-1];

        for(int i=n-2;i>=0;i--){
            dp[i]=Math.min(cost[i]+dp[i+1],cost[i]+dp[i+2]);
        }

        return Math.min(dp[0],dp[1]);
    }
    int find(int index,int n,int[] cost,int[] dp){
        if(index==n) return 0;

        if(index==n-1){
            return dp[index] = cost[index]+find(index+1,n,cost,dp);
        }
        if(dp[index]!=-1) return dp[index];

        return 
        dp[index] = Math.min(cost[index]+find(index+1,n,cost,dp),
        cost[index]+find(index+2,n,cost,dp));
    }
}