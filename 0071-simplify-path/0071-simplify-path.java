class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        String[] pathArr = path.split("/");
        for (int i = 0; i < pathArr.length; i++) {
            if (stk.isEmpty() && (pathArr[i].equals(".") || pathArr[i].equals(".."))) {
                continue;
            }
            else if (!stk.isEmpty() && pathArr[i].equals("..")) {
                stk.pop();
                continue;
            }
            else if (!stk.isEmpty() && pathArr[i].equals(".")) {
                continue;
            }
            else if(pathArr[i].isEmpty()){
                continue;
            }
            stk.push(pathArr[i]);
        }

        String result = "/";
        if(stk.isEmpty()){
            return result;
        }
        for(int i=0;i<stk.size()-1;i++){
            result=result+stk.get(i)+"/";
        }
        result=result+stk.get(stk.size()-1);
        return result;
    }
}