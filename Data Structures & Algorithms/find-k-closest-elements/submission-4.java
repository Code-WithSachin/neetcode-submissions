class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        // Shrink the window until only k elements remain
        while (right - left + 1 > k) {
            int diffLeft = Math.abs(arr[left] - x);
            int diffRight = Math.abs(arr[right] - x);

            // Compare distances to eliminate the worse element
            if (diffLeft > diffRight) {
                left++; // Left is further away, move left inward
            } else {
                right--; // Right is further away (or tied), move right inward
            }
        }

        // Collect the remaining k elements inside the window
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}
