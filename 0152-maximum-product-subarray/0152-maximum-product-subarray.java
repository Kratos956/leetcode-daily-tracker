class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int x=nums[i];
            int y=min*nums[i];
            int z=max*nums[i];

            min=Math.min(x,Math.min(y,z));
            max=Math.max(x,Math.max(y,z));

            ans=Math.max(ans,Math.max(min,max));
        }
        return ans;
    }
}