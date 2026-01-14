class Solution {
    public boolean isHappy(int n) {
        int i=n;
        int j=n;
        while(true){
            i=getNext(i);
            j=getNext(getNext(j));
            if(i==1 || j==1){
                return true;
            }
            if (i == j) {
                return false;
            }
        }
    }
    int getNext(int n){
        int square=0;
        while(n!=0){
            square=square+(n%10)*(n%10);
            n=n/10;
        }
        return square;
    }
   
}