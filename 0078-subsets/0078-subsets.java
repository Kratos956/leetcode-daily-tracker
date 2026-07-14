class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        generate(0,temp,res,nums);
        return res;
    }
    void generate(int index,List<Integer> temp,List<List<Integer>> res,int[] nums){
        if(index==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        generate(index+1,temp,res,nums);
        temp.remove(temp.size()-1);
        generate(index+1,temp,res,nums);
        
    }
}