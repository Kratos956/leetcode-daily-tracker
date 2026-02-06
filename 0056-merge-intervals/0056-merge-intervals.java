class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0 || intervals.length==1) return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList<>();
        int s1=intervals[0][0];
        int e1=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int s2=intervals[i][0];
            int e2=intervals[i][1];
            if(e1>=s2){
                s1=s1;
                e1=Math.max(e1,e2);
                continue;
            }
                merged.add(new int[]{s1,e1});
                s1=s2;
                e1=e2;
                
        }
        merged.add(new int[]{s1,e1});

        return merged.toArray(new int[merged.size()][]);

    }
}