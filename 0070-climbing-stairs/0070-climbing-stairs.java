class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        dp[1]=1;
        return find(n,dp);

    }
    int find(int n,int[] dp){
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=find(n-1,dp)+find(n-2,dp);
        return dp[n];
    }
}