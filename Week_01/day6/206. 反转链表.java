/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currNode = head;
        while (head != null) {
            currNode = head.next;
            head.next = preNode;
            preNode = head;
            head = currNode;
        }

        return preNode;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }
}