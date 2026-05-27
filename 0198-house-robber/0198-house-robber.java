class Solution {
    public int rob(int[] nums) {
        int first = 0;   // dp[i+1]
        int second = 0;  // dp[i+2]

        for (int i = nums.length - 1; i >= 0; i--) {
            int current = Math.max(nums[i] + second, first);
            second = first;
            first = current;
        }

        return first;
    }
}