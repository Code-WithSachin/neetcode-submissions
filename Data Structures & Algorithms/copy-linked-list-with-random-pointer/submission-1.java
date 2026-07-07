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

        if (head == null)
            return null;

        // Step 1: Create copy with only next pointers
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        Node curr = head;

        while (curr != null) {
            copyCurr.next = new Node(curr.val);
            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        // Step 2: Set random pointers
        Node orig = head;
        Node copy = dummy.next;

        while (orig != null) {

            if (orig.random != null) {

                Node tempOrig = head;
                Node tempCopy = dummy.next;

                // Find the corresponding node
                while (tempOrig != orig.random) {
                    tempOrig = tempOrig.next;
                    tempCopy = tempCopy.next;
                }

                copy.random = tempCopy;
            }

            orig = orig.next;
            copy = copy.next;
        }

        return dummy.next;
    }
}
