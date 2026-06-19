class Solution {
    public int uniquePaths(int m, int n) {
        // Total moves to be made
        int N = m + n - 2;
        // Number of down (or right) moves to choose
        int K = Math.min(m - 1, n - 1); 
        
        double ans = 1;
        
        // Calculate N Choose K: (N * (N-1) * ... * (N-K+1)) / (K * (K-1) * ... * 1)
        for (int i = 1; i <= K; i++) {
            ans = ans * (N - K + i) / i;
        }
        
        return (int) Math.round(ans);
    }
}