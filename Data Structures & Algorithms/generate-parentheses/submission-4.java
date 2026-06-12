class Solution {
    public void generate(int index, char[] curr, List<String> ans,
    int openCount, int closeCount, int maxAllowed){

        if(openCount > maxAllowed || closeCount > maxAllowed || closeCount > openCount) return;

        if(index == curr.length){
            ans.add(new String(curr));
            return;
        }

        curr[index] = '(';
        generate(index+1, curr, ans, openCount+1, closeCount, maxAllowed);

        curr[index] = ')';
        generate(index+1, curr, ans, openCount, closeCount+1, maxAllowed);
    }
    public List<String> generateParenthesis(int n) {
        char [] curr = new char[2*n];
        List<String> ans = new ArrayList<>();
        generate(0, curr, ans, 0, 0, n);
        return ans;
    }
}
