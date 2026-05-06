class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode dummy = list1;
        ListNode prevA = null;
        ListNode endB = null;

        ListNode curr = list1;
        int index = 0;

        while (curr != null) {
            if (index == a - 1) {
                prevA = curr;
            }
            if (index == b) {
                endB = curr;
                
            }
            curr = curr.next;
            index++;
        }

        prevA.next = list2;

        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        tail2.next = endB.next;

        return list1;
    }
}