class Pair{
    int a;
    int b;

    Pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}

class Solution {

    public boolean predictTheWinner(int[] nums) {

        Pair[][][] dp=new Pair[nums.length][nums.length][2];

        Pair ans=generate(0,nums.length-1,0,nums,dp);

        return ans.a>=ans.b;
    }

    Pair generate(int i,int j,int player,int[] nums,Pair[][][] dp){

        if(i==j){

            if(player==0)
                return new Pair(nums[i],0);

            return new Pair(0,nums[i]);
        }

        if(dp[i][j][player]!=null)
            return dp[i][j][player];

        Pair score1,score2;

        if(player==0){

            Pair t1=generate(i+1,j,1,nums,dp);
            score1=new Pair(t1.a,t1.b);
            score1.a+=nums[i];

            Pair t2=generate(i,j-1,1,nums,dp);
            score2=new Pair(t2.a,t2.b);
            score2.a+=nums[j];

            if(score1.a-score1.b>=score2.a-score2.b)
                return dp[i][j][player]=score1;
            else
                return dp[i][j][player]=score2;
        }

        else{

            Pair t1=generate(i+1,j,0,nums,dp);
            score1=new Pair(t1.a,t1.b);
            score1.b+=nums[i];

            Pair t2=generate(i,j-1,0,nums,dp);
            score2=new Pair(t2.a,t2.b);
            score2.b+=nums[j];

            if(score1.b-score1.a>=score2.b-score2.a)
                return dp[i][j][player]=score1;
            else
                return dp[i][j][player]=score2;
        }
    }
}