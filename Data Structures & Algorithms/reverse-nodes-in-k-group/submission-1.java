/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        List<Integer> arr = new ArrayList<>();

        // Step 1: Store values
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        // Step 2: Reverse every complete group of k
        for (int i = 0; i + k <= arr.size(); i += k) {
            reverse(arr, i, i + k - 1);
        }

        // Step 3: Build new linked list
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }

    private void reverse(List<Integer> arr, int left, int right) {
        while (left < right) {
            int temp = arr.get(left);
            arr.set(left++, arr.get(right));
            arr.set(right--, temp);
        }
    }
}
