class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        int i=0;
        while(i<k){
            sum=sum+nums[i];
            i++;
        }
        int maxSum=sum;
        int left=0;
        int right=k;
        while(right<nums.length){
            sum=sum+nums[right];
            sum=sum-nums[left];
            if(sum>maxSum){
                maxSum=sum;
            }
            left++;
            right++;
        }
        double result=(double)((double)maxSum/(double)k);
        return result;
    }
}