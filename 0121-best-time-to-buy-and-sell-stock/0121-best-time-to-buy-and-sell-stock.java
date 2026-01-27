class Solution {
    public int maxProfit(int[] nums) {
        int left=0;
        int right=0;
        int maxProfit=0;
        while(right<nums.length){
            if(nums[right]>nums[left]){
                maxProfit=Math.max(maxProfit,nums[right]-nums[left]);
            }
            else if(nums[right]<nums[left]){
                left=right;
            }
            right++;
        }
        return maxProfit;
    }
}