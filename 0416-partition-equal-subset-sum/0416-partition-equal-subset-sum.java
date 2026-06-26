class Solution {
    public boolean canPartition(int[] arr) {
        int total=0;
        for(int i=0;i<arr.length;i++) total+=arr[i];
        if(total%2!=0) return false;

        int sum=total/2;
        
        Boolean[] curr=new Boolean[sum+1];
        
        Arrays.fill(curr,false);
        
        curr[0]=true;
        
        
        for(int i=1;i<=arr.length;i++){
            curr[0] = true; 
            for(int j=sum;j>0;j--){
                if(arr[i-1]<=j){
                    curr[j]=curr[j-arr[i-1]] || curr[j];
                }
            }
        }
        return curr[sum];
    }
}