class Solution {
    public int reverse(int x) {
        long res = 0; // use long to detect overflow
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);

        while (x != 0) {
            int digit = x % 10;
            res = res * 10 + digit;
            x /= 10;
        }

        res *= sign;

        // Check for 32-bit signed integer overflow
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) res;
    }
}
