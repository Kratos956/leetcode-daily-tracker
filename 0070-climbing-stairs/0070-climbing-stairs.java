class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+2];
        Arrays.fill(dp,-1);
        dp[n+1]=0;
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }
        return dp[0];

    }
    int find(int x,int n,int[] dp){
        if(x==n){
            return 1;
        }
        if(x>n) return 0;

        if(dp[x]!=-1){
            return dp[x];
        }
        dp[x]=find(x+1,n,dp)+find(x+2,n,dp);
        return dp[x];
    }
}