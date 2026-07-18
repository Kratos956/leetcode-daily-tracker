class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];

        Arrays.fill(dp[0],10001);
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(j<coins[i-1]) dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
            }
        }
        if(dp[n][amount]>=10001) return -1;
        return dp[n][amount];

    }
    int generate(int n,int amount,int[] coins,int[][] dp){
        if(amount==0) return 0;
        if(n==0) return 10001;

        if(dp[n][amount]!=-1) return dp[n][amount];

        if(amount<coins[n-1]){
            return dp[n][amount]=generate(n-1,amount,coins,dp);
        }

        return dp[n][amount]=Math.min(1 + generate(n,amount-coins[n-1],coins,dp),
                generate(n-1,amount,coins,dp)
        );
    }
}
