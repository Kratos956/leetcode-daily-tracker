class Solution {
    public void reverse(int i,int j,int[] nums){
        while(i<=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index=-1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverse(0, n - 1, nums);
            return;
        }
        int value=nums[index];
        int swap=0;
        for(int i=index;i<nums.length;i++){
            if(nums[i]>value){
                swap=i;
            }
        }
        int temp=nums[index];
        nums[index]=nums[swap];
        nums[swap]=temp;

        reverse(index+1,nums.length-1,nums);
    }
}