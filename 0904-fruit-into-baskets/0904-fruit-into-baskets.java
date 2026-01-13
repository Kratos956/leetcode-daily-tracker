class Solution {
    public int totalFruit(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int maxSum=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            
            if(map.size()>2){
                while(map.size()!=2){
                    map.put(nums[left],map.get(nums[left])-1);
                    sum--;
                    if(map.get(nums[left])==0){
                        map.remove(nums[left]);
                        
                    }
                    left++;
                }
            }
            sum++;
            maxSum=Math.max(sum,maxSum);

        }
        return maxSum;
    }
}