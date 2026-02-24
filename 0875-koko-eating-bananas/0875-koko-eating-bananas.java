class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }

        int left = 1, right = max;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long hours = hoursNeeded(piles, mid);

            if (hours <= h) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    private long hoursNeeded(int[] piles, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }
}