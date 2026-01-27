class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currMax=0, maxSum=nums[0];
        int currMin=0, minSum=nums[0];
        for(int num:nums){
            
            currMax=Math.max(currMax+num,num);
            maxSum=Math.max(maxSum,currMax);

            currMin=Math.min(currMin+num,num);
            minSum=Math.min(currMin,minSum);
        }
        if(Math.abs(maxSum)>Math.abs(minSum)) return Math.abs(maxSum);

        return Math.abs(minSum);
    }
}