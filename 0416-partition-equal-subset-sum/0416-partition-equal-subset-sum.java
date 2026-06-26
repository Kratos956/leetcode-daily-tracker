class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        if(total%2!=0) return false;
        
        Boolean[][] dp=new Boolean[nums.length+1][total/2+1];

        return generate(0,0,total,nums,dp);
    }
    boolean generate(int index,int sum,int total,int[] nums,Boolean[][] dp){
        if(sum+sum==total) return true;
        if(index==nums.length) return false;
        if((2*sum)>total){
            return false;
        }

        if(dp[index][sum]!=null){
            return dp[index][sum];
        }

        return dp[index][sum]=
        generate(index+1,sum+nums[index],total,nums,dp) || 
        generate(index+1,sum,total,nums,dp);
    }
}