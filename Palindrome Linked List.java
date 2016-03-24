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
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode left;
        ListNode right;
        
        ListNode middle = findMiddle(head);
        right = middle.next;
        int length = getLength(head);
        
        if (length % 2 == 1) {
            ListNode newHead = reverseList(head, middle.next);
            left = newHead.next; 
        } else {
            left = reverseList(head, middle.next);
        }
        

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        
        return true;
    }
    
    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        } 
        return count;
    }
    
    public ListNode findMiddle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        
        return slowNode;
    }
    
    public ListNode reverseList(ListNode head, ListNode tail) {
        ListNode previous = null;
        ListNode next;
        ListNode cur = head;
        
        while (cur != tail) {
            next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
        }
        
        return previous;
    }
}
