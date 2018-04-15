class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode temp = head;
        ListNode Pretemp = head;
        while(temp != null) {
            if(temp == head && head.val == val) {
                head = head.next;
                Pretemp = Pretemp.next;
            } else if(temp.val == val) {
                Pretemp.next = temp.next;
            } else {
                if(temp != head)
                    Pretemp = Pretemp.next;
            }
            temp = temp.next;
        }

        return head;
    }

}