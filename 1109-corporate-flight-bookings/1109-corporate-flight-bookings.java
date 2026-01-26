class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int seats[]=new int[n+1];
        for(int[] x:bookings){
            int l=x[0];
            int r=x[1];
            int val=x[2];
            seats[l]+=val;
            if(r+1<n+1){
                seats[r+1]-=val;
            }
        }
        int[] result=new int[n];
        result[0]=seats[1];
        for(int i=1;i<n;i++){
            result[i]=result[i-1]+seats[i+1];
        }
        return result;
    }
}