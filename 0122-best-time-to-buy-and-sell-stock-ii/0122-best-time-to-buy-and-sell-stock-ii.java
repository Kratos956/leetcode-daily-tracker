class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
                continue;
            }
            if(prices[i]>min){
                res+=prices[i]-min;
                min=prices[i];
            }
        }
        return res;
    }
}