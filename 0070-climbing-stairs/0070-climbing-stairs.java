class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return find(0,n,dp);

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