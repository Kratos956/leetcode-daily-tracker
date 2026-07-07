class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(find(0,n,cost,dp),find(1,n,cost,dp));
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