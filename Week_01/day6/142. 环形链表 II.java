/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode pst1 = hasCycle(head);
        if (pst1 == null) {
            return null;
        }
        ListNode pst2 = head;
        while (pst1 != pst2) {
            pst1 = pst1.next;
            pst2 = pst2.next;
        }
        return pst1;
    }

    public ListNode hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}