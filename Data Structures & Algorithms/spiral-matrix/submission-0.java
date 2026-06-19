class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;

        int n = matrix.length, m = matrix[0].length;
        int t = 0, b = n - 1, l = 0, r = m - 1;

        // Keep going until boundaries cross
        while (t <= b && l <= r) {
            
            // 1. Move Right across the top row
            for (int i = l; i <= r; i++) {
                ans.add(matrix[t][i]);
            }
            t++; // Move top boundary down

            // 2. Move Down along the right column
            for (int i = t; i <= b; i++) {
                ans.add(matrix[i][r]);
            }
            r--; // Move right boundary left

            // 3. Move Left across the bottom row (Check if top/bottom crossed)
            if (t <= b) {
                for (int i = r; i >= l; i--) {
                    ans.add(matrix[b][i]);
                }
                b--; // Move bottom boundary up
            }

            // 4. Move Up along the left column (Check if left/right crossed)
            if (l <= r) {
                for (int i = b; i >= t; i--) {
                    ans.add(matrix[i][l]);
                }
                l++; // Move left boundary right
            }
        }

        return ans;
    }
}