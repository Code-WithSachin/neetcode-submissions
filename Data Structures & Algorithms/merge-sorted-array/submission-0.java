class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Step 1: Shift original elements of nums1 to the right end
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }

        int p1 = n; // Read pointer for shifted nums1 elements
        int p2 = 0; // Read pointer for nums2
        int k = 0;  // Write pointer for merged result

        // Step 2: Merge elements from left to right
        while (p1 < m + n && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                nums1[k] = nums1[p1];
                p1++;
            } else {
                nums1[k] = nums2[p2];
                p2++;
            }
            k++;
        }

        // Copy remaining elements from nums2 if any remain
        while (p2 < n) {
            nums1[k] = nums2[p2];
            p2++;
            k++;
        }
    }
}