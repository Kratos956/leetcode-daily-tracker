class Solution {
    public int climbStairs(int n) {
        int last=0;
        int secondLast=1;
        int result=1;

        for(int i=n-1;i>=0;i--){
            result=last+secondLast;
            last=secondLast;
            secondLast=result;
        }
        return result;

    }
}