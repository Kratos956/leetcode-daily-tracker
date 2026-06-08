class Solution {
    boolean Valid(int i,int j,int m,int n){
        return i>=1 && i<=m && j>=1 && j<=n;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<dp[0].length;i++){
            dp[m][i]=1;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][n]=1;
        }

        for(int i=m-1;i>0;i--){
            for(int j=n-1;j>0;j--){
                if(i==m && j==n) dp[i][j]=1;
                else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }

        }

        return dp[1][1];
    }
}