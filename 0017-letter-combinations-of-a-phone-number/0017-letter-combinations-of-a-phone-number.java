class Solution {
    public List<String> letterCombinations(String digits) {

        Map<Character,String> map=new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res=new ArrayList<>();
        generate(digits,digits.length(),res,0,"",map);
        return res;
    }
    void generate(String digits,int n,List<String> list,int idx,String res,Map<Character,String> map){
        if(res.length()==n){
            list.add(res);
            return;
        }

        char ch=digits.charAt(idx);
        String str=map.get(ch);
        for(int i=0;i<str.length();i++){
            res=res+str.charAt(i);
            generate(digits,n,list,idx+1,res,map);
            res=res.substring(0,res.length()-1);
        }
    }
}