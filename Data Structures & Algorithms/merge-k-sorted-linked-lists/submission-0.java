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
    public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> arr = new ArrayList<>();

        // Store all values
        for (ListNode head : lists) {
            while (head != null) {
                arr.add(head.val);
                head = head.next;
            }
        }

        // Sort all values
        Collections.sort(arr);

        // Create the result linked list
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}
