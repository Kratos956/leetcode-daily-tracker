class Solution {
	public int longestCommonSubsequence(String s1, String s2) {
		
		int m = s2.length();
		
		int[] dp = new int[m + 1];
		
		for (int i = s1.length() - 1; i >= 0; i--) {
			
			int diag = 0;
			
			for (int j = m - 1; j >= 0; j--) {
				
				int temp = dp[j];
				
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[j] = 1 + diag;
				} else {
					dp[j] = Math.max(dp[j], dp[j + 1]);
				}
				
				diag = temp;
			}
		}
		
		return dp[0];
	}
}
