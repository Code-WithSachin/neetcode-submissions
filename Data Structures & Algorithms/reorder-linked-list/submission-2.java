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
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }



        ListNode firstHead = head, secHead = reverse(slow.next);
        slow.next = null;

        while(secHead != null){
            ListNode firstHeadNext = firstHead.next;
            ListNode secHeadNext = secHead.next;

            firstHead.next = secHead;
            secHead.next = firstHeadNext;

            firstHead = firstHeadNext;
            secHead = secHeadNext;
        }
    }
}
