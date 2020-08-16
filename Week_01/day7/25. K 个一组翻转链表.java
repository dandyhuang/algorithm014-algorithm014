/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1) {
            return head;
        }
        int count = 1;
        ListNode firstNode = head;
        ListNode resNode = new ListNode(-1);
        ListNode preNode = resNode;
        while (head != null) {
            count++;
            head = head.next;
            if (count == k && head != null) {
                ListNode endNode = head;
                preNode.next = reverseList(firstNode, endNode);
                preNode = firstNode;
                firstNode = firstNode.next;
                count = 1;
                head = firstNode;
            }
        }
        return resNode.next;
    }

    private ListNode reverseList(ListNode firstNode, ListNode endNode) {

        ListNode node =  firstNode.next;
        firstNode.next = endNode.next;
        while (node != endNode) {
            ListNode temp = node.next;
            node.next = firstNode;
            firstNode = node;
            node = temp;
        }
        endNode.next = firstNode;
        return endNode;
    }
}