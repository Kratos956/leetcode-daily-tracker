class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        Arrays.fill(prev, 10001);
        prev[0] = 0;
        curr[0] = 0;

        for (int i = 1; i <= n; i++) {

            
            

            for (int j = 1; j <= amount; j++) {

                if (j < coins[i - 1]) {
                    curr[j] = prev[j];
                } else {
                    curr[j] = Math.min(1 + curr[j - coins[i - 1]], prev[j]);
                }
            }

            prev = curr;
        }

        return prev[amount] >= 10001 ? -1 : prev[amount];
    }
}