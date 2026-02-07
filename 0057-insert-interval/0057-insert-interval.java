//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Online Java Compiler
// Use this editor to write, compile and run your Java code online


import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0) return new int[][]{newInterval};
        List<int[]> list = new ArrayList<>();
        boolean inserted=false;
        for (int[] interval : intervals) {
            if (interval[0] >= newInterval[0]) {
                list.add(new int[]{newInterval[0], newInterval[1]});
                inserted = true;
            }
            list.add(new int[]{interval[0], interval[1]});
        }
        if(!inserted){
            list.add(new int[]{newInterval[0],newInterval[1]});
        }
        return merge(list.toArray(new int[list.size()][]));



    }
    public int[][] merge(int[][] intervals)     {
        if(intervals.length==0 || intervals.length==1) return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList<>();
        int s1=intervals[0][0];
        int e1=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int s2=intervals[i][0];
            int e2=intervals[i][1];
            if(e1>=s2){
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