class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stk1=new Stack<>();
        Stack<Character> stk2=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#'){
                stk1.add(s.charAt(i));
            }
            else if(!stk1.isEmpty()){
                stk1.pop();
            }
        }
        for(int j=0;j<t.length();j++){
            if(t.charAt(j)!='#'){
                stk2.add(t.charAt(j));
            }
            else if(!stk2.isEmpty()){
                stk2.pop();
            }
        }
        if(stk1.size()!=stk2.size()) return false;
        while(!stk1.isEmpty()){
            if(stk1.peek()!=stk2.peek()){
                return false;
            }
            stk1.pop();
            stk2.pop();
        }
        return true;
    }
}