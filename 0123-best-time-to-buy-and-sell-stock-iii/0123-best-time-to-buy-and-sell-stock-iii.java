class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return generate(0,1,2,prices,dp);
    }
    int generate(int index,int buy,int transactions,int[] prices,int[][][] dp){

        if(transactions==0) return 0;
        if(index==prices.length) return 0;

        if(dp[index][buy][transactions]!=-1) return dp[index][buy][transactions];

        if(buy==1){
            return dp[index][buy][transactions]=
            Math.max(-prices[index]+generate(index+1,0,transactions,prices,dp),
            generate(index+1,1,transactions,prices,dp));
        }
        else{
            return dp[index][buy][transactions]=
            Math.max(prices[index]+generate(index+1,1,transactions-1,prices,dp),
            generate(index+1,0,transactions,prices,dp));
        }
    }
}