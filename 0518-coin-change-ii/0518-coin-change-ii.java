class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][amount]=1;
        }

        for(int index=coins.length-1;index>=0;index--){
            for(int sum=amount-1;sum>=0;sum--){
                int take = 0;

                if(sum + coins[index] <= amount) {
                    take = dp[index][sum + coins[index]];
                }

                int skip = dp[index + 1][sum];

                dp[index][sum] = take + skip;
            }
        }

        

        
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