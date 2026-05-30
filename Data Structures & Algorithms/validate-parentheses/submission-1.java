class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else{
                if(st.empty()) return false;
                if(ch == ')'){
                    if(st.peek() != '(') return false;
                }else if(ch == ']'){
                    if(st.peek() != '[') return false;
                }else{
                    if(st.peek() != '{') return false;
                }
                st.pop();
            }
        }

        return st.isEmpty();
    }
}
