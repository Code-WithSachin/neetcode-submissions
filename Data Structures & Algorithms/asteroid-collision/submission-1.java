class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int ast: asteroids){
            boolean isAlive = true;

            while(!st.isEmpty() && ast < 0 && st.peek() > 0){
                if(st.peek() < Math.abs(ast)){
                    st.pop();
                    continue;
                }else if(st.peek() == Math.abs(ast)){
                    st.pop();
                    isAlive = false;
                    break;
                }else{
                    isAlive = false;
                    break;
                }
            }

            if(isAlive) st.push(ast);
        }

        int ans[] = new int[st.size()];
        int i = st.size()-1;
        while(!st.isEmpty()){
            ans[i--] = st.pop();
        }

        return ans;
    }
}