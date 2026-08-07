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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;

        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(size == n) return head.next;

        temp = head;
        int traverseTill = size-n-1;
        while(traverseTill > 0){
            temp = temp.next;
            traverseTill--;
        }
        temp.next = temp.next.next;

        return head;
    }
}
