class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int prefixSum=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) prefixSum+=-1;
            if(nums[i]==1) prefixSum+=1;
            if(map.containsKey(prefixSum)){
                max=Math.max(i-map.get(prefixSum),max);
            }
            else{
                map.put(prefixSum,i);
            }

        }
        return max;
    }
}