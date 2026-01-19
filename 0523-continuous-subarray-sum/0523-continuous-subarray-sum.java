class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        if(nums.length<2) return false;
        int prefixSum=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            int rem=prefixSum%k;
            if(map.containsKey(rem) && (i-map.get(rem))>=2){
                return true;
            }
            if(!map.containsKey(rem)){
                map.put(rem,i);
            }
        }
        return false;

    }
}