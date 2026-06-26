class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int i=0;i<nums.length;i++) total+=nums[i];
        if(total%2!=0) return false;
        
        Boolean[][] dp=new Boolean[n+1][total/2+1];
        // Arrays.fill(dp[n],false);          //LAST ROW 
        // for(int i=0;i<dp.length;i++){
        //     dp[i][total/2]=true;           //LAST COL
        // }
        // for(int i=n-1;i>-1;i--){
        //     for(int j=total/2-1;j>-1;j--){
        //         if((i+nums[i])*2>j){
        //             dp[i][j]=dp[i+1][j];
        //         }
        //         else{
        //             dp[i][j]=dp[i+1][j+nums[i]] || dp[i+1][j];
        //         }
        //     }
        // }



        return generate(0,0,total,nums,dp);
    }
    boolean generate(int index,int sum,int total,int[] nums,Boolean[][] dp){
        if(sum+sum==total) return true;
        if(index==nums.length) return false;

        if(dp[index][sum]!=null){
            return dp[index][sum];
        }
        if((sum+nums[index])*2>total){
            return generate(index+1,sum,total,nums,dp);
        }

        return dp[index][sum]=
        generate(index+1,sum+nums[index],total,nums,dp) || 
        generate(index+1,sum,total,nums,dp);
    }
}