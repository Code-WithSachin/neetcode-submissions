class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else{
                // If the stack is empty, return false as we have a closing without a matching opening
                if (st.isEmpty()) return false;

                // Check for matching pairs of brackets
                if (ch == ')' && st.peek() != '(') return false;
                if (ch == ']' && st.peek() != '[') return false;
                if (ch == '}' && st.peek() != '{') return false;
                
                // Pop the matched opening bracket
                st.pop();
            }
        }

        return st.isEmpty();
    }
}
