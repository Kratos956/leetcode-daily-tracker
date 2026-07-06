class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int first=0;
        int second=1;
        int third=1;
        for(int i=2;i<n+1;i++){
            third=first+second;
            first=second;
            second=third;
        }
        return third;
    }
}