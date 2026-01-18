class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int curSum=0;
        for(int i=0;i<nums.length;i++){
            curSum=curSum+nums[i];
            int rem=curSum%k;
            if(map.containsKey((rem-k)%k)){
                count=count+map.get((rem-k)%k);
            }
            map.put((rem-k)%k,map.getOrDefault((rem-k)%k,0)+1);
        }
        return count;
    }
}