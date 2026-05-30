class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];

        for(int i=0;i<coins.length;i++){
        Arrays.fill(dp[i], -1);
        }
        return generate(0,amount,coins,dp);
    }
    int generate(int index,int amount,int[] coins,int[][] dp){

        if(amount==0) return 1;

        if(amount<0) return 0;

        if(index>=coins.length) return 0;

        if(dp[index][amount] != -1) return dp[index][amount];

        return dp[index][amount]=generate(index, amount-coins[index], coins, dp)+generate(index+1, amount, coins, dp);
    }
}