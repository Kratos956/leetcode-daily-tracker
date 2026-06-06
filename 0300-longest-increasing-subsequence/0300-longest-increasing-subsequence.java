class Solution {
    public int lengthOfLIS(int[] arr) {
        int size=0,start=0,mid=0,end=0,index=0;
        int[] res=new int[arr.length];
        res[0]=arr[0];

        for(int i=1;i<arr.length;i++){
            start=0;
            end=size;
            index=size+1;
            while(start<=end){
                mid=start+(end-start)/2;
                if(res[mid]<arr[i]){
                    start=mid+1;
                }
                else{
                    index=mid;
                    end=mid-1;
                }
            }
            res[index]=arr[i];
            size=Math.max(size,index);
        }
        return size+1;
    }
}