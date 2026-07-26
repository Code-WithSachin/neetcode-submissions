class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(String op: operations){
            if(op.equals("C")) st.pop();
            else if(op.equals("D")) st.push(st.peek()*2);
            else if(op.equals("+")){
                int firstNum = st.pop();
                int secNum = st.pop();
                int sum = firstNum+secNum;
                st.push(secNum);
                st.push(firstNum);
                st.push(sum);
            }else{
                st.push(Integer.parseInt(op));
            }
        }

        int ans = 0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }

        return ans;
    }
}