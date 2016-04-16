/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        
        ListNode curA = headA;
        ListNode curB = headB;
        
        int gap = Math.abs(lengthA - lengthB);
        
        
        if (lengthA > lengthB) {
            for (int i = 0; i < gap; i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < gap; i++) {
                curB = curB.next;
            }
        }
        
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        
        return null;
    }
    
    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
