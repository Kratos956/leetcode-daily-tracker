class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];

        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i], -1);
        }
        generate(0,0,amount,coins,dp);
        if(dp[0][0]==-1) return 1;
        return dp[0][0];
    }
    int generate(int index,int sum,int amount,int[] coins,int[][] dp){

        if(sum==amount) return 1;
        if(sum>amount) return 0;
        if(index>=coins.length) return 0;
        
        

        if(dp[index][sum]!=-1) return dp[index][sum];


        dp[index][sum]=generate(index,sum+coins[index],amount,coins,dp)+generate(index+1,sum,amount,coins,dp);

        return dp[index][sum];
    }
}