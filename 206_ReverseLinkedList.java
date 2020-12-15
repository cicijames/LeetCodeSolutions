//Runtime 0ms, Memory 39 MB.

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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode end = reverseListHelper(head, head.next);
        head.next = null;
        return end;
    }
    
    public static ListNode reverseListHelper(ListNode parent, ListNode child) {
        if(child.next != null) {
            ListNode tmp = child.next;
            child.next = parent;
            return reverseListHelper(child, tmp);
        }
        child.next = parent;
        return child;
    }
}