//RunTime 0 ms, Memory 38.3 MB.

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    
        if(l1 == null && l2 == null) {
            return l1;
        }
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        if(l1.next != null && l2.next != null) {
            ListNode lowerVal = l1.val <= l2.val ? l1 : l2;
            ListNode higherVal = l1.val <= l2.val ? l2 : l1;
            if(lowerVal.next.val <= higherVal.val) {
                mergeTwoLists(lowerVal.next, higherVal);
            }
            else {
                ListNode tmp = lowerVal.next;
                lowerVal.next = higherVal;
                mergeTwoLists(higherVal, tmp);
            }
            return lowerVal;
        }
        if(l1.next != null || l2.next != null) {
            ListNode nullNext = l1.next == null ? l1 : l2;
            ListNode notNull = l1.next == null ? l2 : l1;
            if(nullNext.val <= notNull.val) {
                nullNext.next = notNull;
                return nullNext;
            }
            if(nullNext.val > notNull.next.val) {
                mergeTwoLists(nullNext, notNull.next);
                return notNull;
            }
            ListNode tmp = notNull.next;
            notNull.next = nullNext;
            nullNext.next = tmp;
            return notNull;
        }
        if(l1.val <= l2.val) {
            l1.next = l2;
            return l1;
        }
        l2.next = l1;
        return l2;       
    }
}