class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=0;
        int fast=1;
        while(fast<nums.length){
            if(nums[fast]==nums[fast-1]){
                fast++;
            }
            else{
                slow=slow+1;
                nums[slow]=nums[fast];
                fast++;
            }
        }
        return slow+1;
    }
}