/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode cur = head;
        ListNode prev = cur;
        cur = cur.next;
        ListNode newHead = cur;
        
        while (true) {
            ListNode next = cur.next;
            cur.next = prev;
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }
            
            prev.next = next.next;
            
            prev = next;
            cur = prev.next;
        }
        return newHead;
    }
}
