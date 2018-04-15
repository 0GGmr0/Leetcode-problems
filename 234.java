class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode[] temp = new ListNode[1000000];
        ListNode temp1 = head;
        int count;
        for(count = 0; temp1 != null; count++) {
            temp[count] = temp1;
            temp1 = temp1.next;
        }
        for(int i = --count; i > count/2; i--) {         
            if(head.val != temp[i].val) return false;
            head = head.next;
        }
        return true;
    }
}