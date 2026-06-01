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

        if(head.next == null) return null;
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        int removeIndex = size - n;
        if(removeIndex == 0) return head.next;
        int currIndex = 0;
        ListNode curr = head, prev = null;
        while(currIndex < removeIndex){
            prev = curr;
            curr = curr.next;
            currIndex++;
        }
        prev.next = curr.next;
        return head;
    }
}
