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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        int length = getLength(head);
        int times = length / k;
        if (times == 0) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode start = dummyNode;
        for (int i = 0; i < times; i++) {
            start = reverse(start, k);
        }
        return dummyNode.next;
    }
    
    public int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }
    
    public ListNode reverse(ListNode head, int k) {
        ListNode first = head.next;
        ListNode newLast = first;
        ListNode second = first.next;
        ListNode next;
        ListNode nextFirst;
        for (int i = 0; i < k - 1; i++) {
            next = second.next;
            second.next = first;
            first = second;
            second = next;
        }
        head.next = first;
        newLast.next = second;
        return newLast;
    }
}
