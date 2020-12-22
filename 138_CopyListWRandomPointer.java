//Runtime 0ms, Memory 38.5 MB

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
        if(head == null) {
            return head;
        }
        
        Node headCopy = new Node(head.val);
        Map<Node, Node> nodesAndCopies = new HashMap<Node, Node>();
        copyRandomListHelper(head, headCopy, nodesAndCopies);
        return headCopy;
    }
    
    public static void copyRandomListHelper(Node original, Node copy, Map<Node, Node> nodesAndCopies) {
        nodesAndCopies.put(original, copy);
        if(original.next != null) {
            copy.next = new Node(original.next.val);
            copyRandomListHelper(original.next, copy.next, nodesAndCopies);
        }
        if(original.random != null) {
            copy.random = nodesAndCopies.get(original.random);
        }       
    }
}