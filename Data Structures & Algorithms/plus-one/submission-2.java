class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1, n = digits.length;
        while(i>=0 && digits[i] == 9){
            digits[i--] = 0;
        }
        if(i==-1){
            int ans[] = new int[n+1];
            ans[0] = 1;
            return ans;
        }else{
            digits[i] = digits[i]+1;
        }

        return digits;
    }
}
