class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        generate(nums,temp,ans,0,nums.length);
        return ans;
    }
    void generate(int[] arr,List<Integer> list,List<List<Integer>> ans,int idx,int n){
        if(idx==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(list.contains(arr[i])){
                continue;
            }
            list.add(arr[i]);
            generate(arr,list,ans,idx+1,n);
            list.removeLast();
            
            
        }
    }
}