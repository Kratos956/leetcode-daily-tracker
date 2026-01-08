class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int runningSum=0;
        map.put(0,-1);
        if (nums.length < 2) return false;
        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
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