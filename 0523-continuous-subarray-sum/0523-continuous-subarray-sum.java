class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // remainder 0 at index -1

        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];

            int rem;
            if (k != 0) {
                rem = runningSum % k;
            } else {
                rem = runningSum; // handle k = 0 separately
            }

            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                // store earliest index only
                map.put(rem, i);
            }
        }
        return false;
    }
}
