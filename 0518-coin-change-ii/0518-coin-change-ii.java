class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(n,amount,coins,dp);
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