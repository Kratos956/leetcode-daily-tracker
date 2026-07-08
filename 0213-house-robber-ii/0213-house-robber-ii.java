class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: Rob houses [0 ... n-2]
        int curr1 = Math.max(nums[n - 3], nums[n - 2]);
        int next1 = nums[n - 2];
        int nextNext1;

        for (int i = n - 4; i >= 0; i--) {
            nextNext1 = next1;
            next1 = curr1;
            curr1 = Math.max(nums[i] + nextNext1, next1);
        }

        // Case 2: Rob houses [1 ... n-1]
        int curr2 = Math.max(nums[n - 2], nums[n - 1]);
        int next2 = nums[n - 1];
        int nextNext2;

        for (int i = n - 3; i > 0; i--) {
            nextNext2 = next2;
            next2 = curr2;
            curr2 = Math.max(nums[i] + nextNext2, next2);
        }

        return Math.max(curr1, curr2);
    }
}