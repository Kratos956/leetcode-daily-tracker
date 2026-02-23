class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int res=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                res=Math.min(res,nums[mid]);
                high=mid-1;
            }
        }
        return res;
    }
}