class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode temp = head;
        ListNode preTemp = head;
        while(temp != null) {
            if(temp == head) {
                temp = temp.next;
                continue;
            } else if(preTemp.val == temp.val) {
                preTemp.next = temp.next;
                temp = temp.next;
            } else {
                preTemp = preTemp.next;
                temp = temp.next;
            }
        }
//        while(head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
        return head;
    }
}