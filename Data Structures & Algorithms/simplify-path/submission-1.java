class Solution {
    public String simplifyPath(String path) {
        String[] pathList = path.split("/");
        Stack<String> st = new Stack<>();

        for(String p: pathList){
            if(!st.isEmpty() && p.equals("..")) st.pop();
            else if(!p.equals(".") && !p.equals("") && !p.equals("..")){
                st.push(p);
            }
        }

        StringBuilder ans = new StringBuilder();

        for(String dir : st){
            ans.append("/").append(dir);
        }

        return ans.length() == 0 ? "/" : ans.toString();
    }
}