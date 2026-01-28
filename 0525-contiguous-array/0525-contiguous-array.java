class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) sum-=1;
            if(nums[i]==1) sum+=1;
            if(map.containsKey(sum)){
                count=Math.max(count,i-map.get(sum));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return count;
    }
}