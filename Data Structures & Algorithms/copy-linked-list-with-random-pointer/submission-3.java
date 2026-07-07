/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node curr = head;
        Node dummyHead = new Node(0);
        Node dummy = dummyHead;

        while(curr != null){
            dummy.next = new Node(curr.val);
            curr = curr.next;
            dummy = dummy.next;
        }
        
        Node tempOriHead = head;
        Node tempCopyHead = dummyHead.next;

        while(tempOriHead != null){
            if(tempOriHead.random != null){
                
                Node origiIterator = head;
                Node copyIterator = dummyHead.next;

                while(tempOriHead.random != origiIterator){
                    origiIterator = origiIterator.next;
                    copyIterator = copyIterator.next;
                }
                tempCopyHead.random = copyIterator;
            }
            tempOriHead = tempOriHead.next;
            tempCopyHead = tempCopyHead.next;
        }
        return dummyHead.next;
    }
}
