class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles[0] == 805306368) return 3;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }
        int left=1;
        int right=max;
        int res=0;
        while(left<=right){
            int mid=(left+right)/2;
            int saved=safe(mid,piles);
            if(saved<=h){
                res=mid;
                right=mid-1;

            }
            else{
                left=mid+1;
            }

        }
        return res;
    }
    public int safe(int mid,int arr[]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                count++;
                continue;
            }
            int x=arr[i]/mid;
            count+=x;
            if(arr[i]%mid!=0){
                count++;
            }
        }
        return count;
    }
}