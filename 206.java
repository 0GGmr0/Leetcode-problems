class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        int i = 0;
        ListNode[] lists = new ListNode[100005];
        for (i = 0; head != null; i++) {
            lists[i] = head;
            head = head.next;
        }
        ListNode newHead = lists[--i];
        ListNode temp = newHead;
        for(i--; i >= 0; i--) {
            temp.next = lists[i];
            temp = temp.next;
        }
        temp.next = null;

        return newHead;
    }

}