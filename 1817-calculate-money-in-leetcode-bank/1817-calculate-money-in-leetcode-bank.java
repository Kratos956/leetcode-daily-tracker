class Solution {
    public int totalMoney(int n) {
        int res=0;
        int x=1;
        int count=0;
        for(int i=1;i<=n;i++){
            res=res+x;
            x=x+1;
            if(i%7==0){
                count=count+1;
                x=1+count;
        }
    }
    return res;
}
}