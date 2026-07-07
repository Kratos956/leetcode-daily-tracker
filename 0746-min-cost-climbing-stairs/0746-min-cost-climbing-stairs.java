class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int Last = 0;
        int secondLast = cost[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int third = Math.min(cost[i] + secondLast, cost[i] + Last);
            Last = secondLast;
            secondLast = third;
        }

        return Math.min(Last, secondLast);
    }
}