class Solution {
    public int climbStairs(int n) {
        int first=0;
        int second=1;
        int third=1;
        for(int i=n-1;i>=0;i--){
            third=first+second;
            first=second;
            second=third;
        }
        return third;

    }
}