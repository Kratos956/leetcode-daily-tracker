class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int high=matrix.length-1;
        int res=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(matrix[mid][0]<=target){
                res=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        int l=0;
        int r=matrix[0].length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(matrix[res][mid]==target){
                return true;
            }
            else if(matrix[res][mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return false;
    }
}