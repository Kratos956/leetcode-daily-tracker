class Solution {
    public int[][] intervalIntersection(int[][] FL, int[][] SL) {
        List<int[]> list=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<FL.length && j<SL.length){
            int s1=FL[i][0];
            int e1=FL[i][1];
            int s2=SL[j][0];
            int e2=SL[j][1];
            if(e1>=s2 && s1<=e2){
                list.add(new int[]{Math.max(s1,s2),Math.min(e1,e2)});
            }
            if(e1>e2){
                j++;
            }
            else{
                i++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}