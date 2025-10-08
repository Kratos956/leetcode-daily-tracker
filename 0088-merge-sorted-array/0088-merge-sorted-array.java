class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m+n-1;
        int j=nums2.length-1;
        while(j>=0){
            int temp=nums1[i];
            nums1[i]=nums2[j];
            nums2[j]=temp;
            i--;
            j--;
        }
        Arrays.sort(nums1);
    }
}