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
        ListNode dummy = new ListNode(-1);
        ListNode leftNode = dummy, leftPrev = null;
        dummy.next = head;

        for(int i = 0; i<left; i++){
            leftPrev = leftNode;
            leftNode = leftNode.next;
        }
        ListNode rightNode = leftNode;
        for(int i=left; i<right; i++){
            rightNode = rightNode.next;
        }

        ListNode rightAfter = rightNode.next;
        rightNode.next = null;

        ListNode curr = leftNode, prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        leftPrev.next = prev;
        leftNode.next = rightAfter;

        return dummy.next;
    }
}