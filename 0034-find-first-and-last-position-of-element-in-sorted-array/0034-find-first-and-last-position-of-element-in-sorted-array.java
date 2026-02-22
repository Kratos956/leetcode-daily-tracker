class Solution {
    public int[] searchRange(int[] arr, int x) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]==x){
                min=Math.min(min,mid);
                r=mid-1;
            }
            else if(arr[mid]>x){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        l=0;
        r=arr.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]==x){
                max=Math.max(max,mid);
                l=mid+1;
            }
            else if(arr[mid]>x){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        if(min==Integer.MAX_VALUE){
            min=-1;
        }
        if(max==Integer.MIN_VALUE){
            max=-1;
        }
        return new int[]{min,max};
    }
}
