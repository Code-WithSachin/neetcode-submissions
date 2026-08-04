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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Find beforeLeft
        ListNode beforeLeft = dummy;
        for (int i = 1; i < left; i++) {
            beforeLeft = beforeLeft.next;
        }

        // Identify leftNode
        ListNode leftNode = beforeLeft.next;

        // Find rightNode
        ListNode rightNode = leftNode;
        for (int i = left; i < right; i++) {
            rightNode = rightNode.next;
        }

        // Identify afterRight
        ListNode afterRight = rightNode.next;

        // Detach sublist
        rightNode.next = null;

        // Reverse sublist
        ListNode prev = null;
        ListNode curr = leftNode;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Reconnect
        beforeLeft.next = prev;
        leftNode.next = afterRight;

        return dummy.next;
    }
}