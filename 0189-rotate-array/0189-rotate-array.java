class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        if(nums.length==1){
            return;
        }
        if(k>nums.length){
            int i=0;
            int j=nums.length-1;
            while(i<=j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
            return;
        }
        int result[]=new int[nums.length];
        int i=0;
        while(k!=0){
            result[i]=nums[nums.length-k];
            i++;
            k--;
        }
        int j=0;
        while(i<nums.length){
            result[i]=nums[j];
            i++;
            j++;
        }
        for(int x=0;x<nums.length;x++){
            nums[x]=result[x];
        }
    }
}