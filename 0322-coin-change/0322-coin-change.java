class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[] curr = new int[amount + 1];
        for(int i=1;i<curr.length;i++){
            curr[i]=10001;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                curr[j] = Math.min(1 + curr[j - coins[i - 1]], curr[j]);
            }

        }

        return curr[amount] >= 10001 ? -1 : curr[amount];
    }
}