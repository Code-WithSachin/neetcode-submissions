class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        Stack<Integer> st = new Stack();
        
        for(int i = 0; i<tokens.length; i++){
            String str = tokens[i];

            if(str.equals("+")){
                st.push(st.pop()+st.pop());
            }else if(str.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);
            }else if(str.equals("*")){
                st.push(st.pop()*st.pop());
            }else if(str.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }else{
                st.push(Integer.parseInt(str));
            }
        }

        return st.pop();
    }
}
