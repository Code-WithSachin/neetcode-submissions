class Solution {

    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];

        mergeSort(nums, temp, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] nums, int[] temp, int left, int right) {

        // Base case
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // Sort left half
        mergeSort(nums, temp, left, mid);

        // Sort right half
        mergeSort(nums, temp, mid + 1, right);

        // Merge both sorted halves
        merge(nums, temp, left, mid, right);
    }

    private void merge(int[] nums, int[] temp, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int k = left;

        // Pick smaller element from left/right half
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // Remaining elements from left half
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // Remaining elements from right half
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy merged result back to nums
        for (int index = left; index <= right; index++) {
            nums[index] = temp[index];
        }
    }
}