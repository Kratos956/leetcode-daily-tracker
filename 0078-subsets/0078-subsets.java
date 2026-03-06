class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        possible(nums, 0, list, res);
        return res;
    }
    void possible(int[] nums,int i,List<Integer> temp,List<List<Integer>> list){
        if(i==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        possible(nums,i+1,temp,list);
        temp.removeLast();
        possible(nums,i+1,temp,list);
    }
}