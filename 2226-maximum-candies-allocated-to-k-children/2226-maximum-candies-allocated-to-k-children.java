class Solution {
    public boolean isPossible(int[] arr,int target,long k){
        long count=0;
        for(int i=0;i<arr.length;i++){
            count=count+arr[i]/target;
            if(count>=k) return true;
        }
        return false;

    }
    public int maximumCandies(int[] candies, long k) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            max=Math.max(max,candies[i]);
        }
        int low=1;
        int high=max;
        int res=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(candies,mid,k)){
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