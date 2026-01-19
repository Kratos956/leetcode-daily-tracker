class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        if(nums.length<2) return false;
        int prefixSum=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            if(map.containsKey(prefixSum%k) && (i-map.get(prefixSum%k))>=2){
                return true;
            }
            if(prefixSum%k==0 && i>=1) return true;
            if(!map.containsKey(prefixSum%k)){
                map.put(prefixSum%k,i);
            }
        }
        if(prefixSum%k==0) return true;
        return false;

    }
}