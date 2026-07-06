class Solution {
    public int fib(int n) {
        if(n==0 || n==1) return n;
        int a=0;
        int b=1;
        int c=0;
        for(int i=2;i<n+1;i++){
            c=a+b;
            a=b;
            b=c;
        }

        return c;
    }
    int dpSol(int n,int[] dp){
        
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fib(n-1)+fib(n-2);
    }
}