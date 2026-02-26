class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        // ✅ missing feasibility check
        if ((long) m * k > bloomDay.length) return -1;

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int p : bloomDay) {
            max = Math.max(max, p);
            min = Math.min(min, p);
        }

        int l = min;
        int r = max;

        while (l <= r) {
            int mid = l + (r - l) / 2;   // ✅ safer mid

            if (isPossibleBouquets(bloomDay, m, k, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean isPossibleBouquets(int[] bloomDay, int m, int k, int day) {
        int total = 0;
        int count = 0;   // ✅ added

        for (int i = 0; i < bloomDay.length; i++) {   // ✅ full traversal
            if (bloomDay[i] <= day) {
                count++;
                if (count == k) {
                    total++;
                    count = 0;   // ✅ reset after bouquet
                }
            } else {
                count = 0;       // ✅ break consecutiveness
            }

            if (total >= m) return true;
        }
        return false;
    }
}