class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int x=generate(n,amount,coins,dp);
        if(x>=10001) return -1;
        return x;
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
