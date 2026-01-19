class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(k-nums[i])){
                count=count+map.get(k-nums[i]);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            
        }
        return count;
    }
}