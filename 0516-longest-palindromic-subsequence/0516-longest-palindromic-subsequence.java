class Solution {

    public int longestPalindromeSubseq(String s) {
        // code here

        StringBuilder s1= new StringBuilder(s);
        s1.reverse();
        int index=s.length();

        int[] curr=new int[index+1];
        for(int i=1;i<=index;i++) {
            int prev=0;
            for (int j = 1; j <= index; j++) {
                int temp=curr[j];
                if (s.charAt(i - 1) == s1.charAt(j - 1)) {
                    curr[j] = 1 + prev;
                } else {
                    curr[j] = Math.max(curr[j-1],curr[j]);
                }
                prev=temp;

            }
        }
        return curr[index];
    }
}