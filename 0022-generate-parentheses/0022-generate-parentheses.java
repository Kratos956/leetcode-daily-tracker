class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(new StringBuilder(),0,0,n,list);
        return list;
    }
    void generate(StringBuilder s,int open,int close,int n,List<String> list){
        if(open==n && close==n){
            list.add(s.toString());
            return;
        }

        if(open<n){
            s=s.append('(');
            generate(s,open+1,close,n,list);
            s.deleteCharAt(s.length()-1);
        }
        if(close<n && close<open){
            s=s.append(')');
            generate(s,open,close+1,n,list);
            s.deleteCharAt(s.length()-1);
            
        }


    }
}