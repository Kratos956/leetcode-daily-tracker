class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int currSum=0;
        map.put(0,1);
        int result=0;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(map.containsKey(currSum-k)){
                result+=map.get(currSum-k);
            }
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return result;
    }
}