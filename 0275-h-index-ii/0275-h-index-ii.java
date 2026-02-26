class Solution {
    public int possible(int[] arr,int target){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=target){
                count++;
            }
        }
        return count;

    }
    public int hIndex(int[] citations) {
        int max=Integer.MIN_VALUE;
        for(int x:citations){
            max=Math.max(max,x);
        }
        int low=0;
        int high=max;
        int res=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(citations,mid)>=mid){
                res=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return res;
    }
}