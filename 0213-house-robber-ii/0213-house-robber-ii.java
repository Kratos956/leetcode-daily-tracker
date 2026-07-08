class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int[] dp1=new int[n-1];
        int[] dp2=new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(find(0,n-2,nums,dp1),find(1,n-1,nums,dp2));
    }
    int find(int index,int n,int[] nums,int[] dp){
        if(index==n) return nums[n];
        if(index==n-1) return Math.max(nums[n-1],nums[n]);

        if(dp[index]!=-1) return dp[index];


        return dp[index]=
        Math.max(nums[index]+find(index+2,n,nums,dp),find(index+1,n,nums,dp));
    }
}