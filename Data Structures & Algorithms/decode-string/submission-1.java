class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == ']') {
                // Get string inside []
                StringBuilder str = new StringBuilder();
                while (!st.peek().equals("[")) {
                    str.insert(0, st.pop());
                }

                // Remove '['
                st.pop();

                // Get the number (can be multiple digits)
                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    num.insert(0, st.pop());
                }

                int repeat = Integer.parseInt(num.toString());

                // Repeat the string
                StringBuilder decoded = new StringBuilder();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(str);
                }

                // Push back for possible outer decoding
                st.push(decoded.toString());
            }else{
                st.push(String.valueOf(ch));
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.insert(0, st.pop());
        }

        return ans.toString();
    }
}