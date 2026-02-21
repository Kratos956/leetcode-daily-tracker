class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk=new Stack<>();
        int res[]=new int[temperatures.length];
        stk.add(temperatures.length-1);
        res[res.length-1]=0;
        for(int i=temperatures.length-2;i>=0;i--){
            while(!stk.isEmpty() && temperatures[stk.peek()]<=temperatures[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                res[i]=0;
            }
            else{
                res[i]=stk.peek()-i;
            }
            stk.add(i);
        }
        return res;
    }
}