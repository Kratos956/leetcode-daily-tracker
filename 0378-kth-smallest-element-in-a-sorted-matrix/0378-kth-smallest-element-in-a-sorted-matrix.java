class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int l=matrix[0][0];
        int h=matrix[matrix.length-1][matrix[0].length-1];
        int res=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(possible(matrix,mid)>=k){
                res=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
    public int possible(int[][] arr,int target){
        int row=arr.length-1;
        int column=0;
        int count=0;
        while(row>=0 && column<arr.length){
            if(arr[row][column]<=target){
                count=count+row+1;
                column++;
            }
            else{
                row--;
            }
        }
        return count;
    }
}