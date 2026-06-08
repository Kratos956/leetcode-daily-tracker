class Solution {
    boolean Valid(int i,int j,int m,int n){
        return i>=1 && i<=m && j>=1 && j<=n;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return generate(1,1,m,n,dp);
    }
    int generate(int i,int j,int m,int n,int[][] dp){
        if(!Valid(i,j,m,n)) return 0;
        if(i==m && j==n){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int bottom=generate(i+1,j,m,n,dp);
        int right=generate(i,j+1,m,n,dp);

        return dp[i][j]=bottom+right;
    }
}