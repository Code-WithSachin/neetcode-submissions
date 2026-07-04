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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode dummyHead = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                dummyHead.next = list1;
                list1 = list1.next;
            }else{
                dummyHead.next = list2;
                list2 = list2.next;
            }
            dummyHead = dummyHead.next;
        }

        while(list1 != null){
            dummyHead.next = list1;
            list1 = list1.next;
            dummyHead = dummyHead.next;
        }

        while(list2 != null){
            dummyHead.next = list2;
            list2 = list2.next;
            dummyHead = dummyHead.next;
        }

        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode result = lists[0];
        for(int i =1; i<lists.length; i++){
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }
}
