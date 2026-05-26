class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int[] arr=new int[n+1];
        Arrays.fill(arr,-1);
        arr[0]=0;
        arr[1]=1;
        return find(n,arr);



    }
    int find(int n,int[] arr){
        if(arr[n]!=-1){
            return arr[n];
        }

        arr[n]=find(n-1,arr)+find(n-2,arr);
        return arr[n];

    }
}