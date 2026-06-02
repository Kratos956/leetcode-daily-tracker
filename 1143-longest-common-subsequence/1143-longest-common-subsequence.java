class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[] prev=new int[s2.length()+1];
        int[] curr=new int[s2.length()+1];

        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    curr[j]=1+prev[j+1];
                }
                else{
                    curr[j]=Math.max(prev[j],curr[j+1]);
                }
            }
            prev = curr.clone() ;
        }

        return prev[0];
    }
}