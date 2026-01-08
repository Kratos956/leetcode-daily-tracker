class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int curSum=0;
        for(int i=0;i<nums.length;i++){
            curSum=curSum+nums[i];
            if(map.containsKey(curSum-k)){
                count=count+map.get(curSum-k);
            }
            map.put(curSum,map.getOrDefault(curSum,0)+1);
        }
        return count;
    }
}