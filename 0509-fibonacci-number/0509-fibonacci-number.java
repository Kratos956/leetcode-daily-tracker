class Solution {
    public int fib(int n) {
        int[] arr=new int[n+1];
        return find(n,arr);
        

    }
    int find(int n,int[] arr){
        if(n==0) return 0;
        if(n==1) return 1;
        
        arr[n]=find(n-1,arr)+find(n-2,arr);
        return arr[n];
        
    }
}