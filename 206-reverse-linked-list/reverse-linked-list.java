/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { 
 *         this.val = val; 
 *         this.next = next; 
 *     }
 * }
 */
class Solution {

    public ListNode reverseList(ListNode head) {
        return solve(null, head);
    }

    public ListNode solve(ListNode prev, ListNode curr) {

        if (curr == null) {
            return prev;
        }

        ListNode nextNode = curr.next;

        curr.next = prev;

        return solve(curr, nextNode);
    }
}