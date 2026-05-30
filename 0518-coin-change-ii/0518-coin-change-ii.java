class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][0] =1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
    int find(int index,int amount,int[] coins,int[][] dp){
        if(amount==0) return 1;
        if(index==0) return 0;

        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }

        if(coins[index-1]>amount){
            return dp[index][amount]=find(index-1,amount,coins,dp);
        }
        else{
            return dp[index][amount]=find(index,amount-coins[index-1],coins,dp)+find(index-1,amount,coins,dp);
        }
    }
}