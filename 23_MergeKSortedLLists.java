//Runtime 4ms, Memory 41.4 MB.

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
    public ListNode mergeKLists(ListNode[] lists) {
        
        Comparator<ListNode> comp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        
        Queue<ListNode> queue = new PriorityQueue<ListNode>(comp);
        for(ListNode node : lists) {
            if(node != null) {
               queue.add(node); 
            }      
        }
        if(queue.isEmpty()) {
            return new ListNode(0).next;
        }
        return getNext(queue);
    }
    
    public static ListNode getNext(Queue<ListNode> queue) {       
        ListNode lowest = queue.poll();
        if(queue.isEmpty()) {
            return lowest;
        }
        
        if(lowest.next == null) {
            lowest.next = getNext(queue);
        }
        else {
            queue.add(lowest.next);
            lowest.next = getNext(queue);
        }
        return lowest;
    }
}