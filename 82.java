import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tempHead = new ListNode(0),
                 pre = tempHead,
                 l = head;
        pre.next = head;
        head = pre;
        while(l != null) {
            ListNode lNext = l.next;
            int judge = 0;
            while (lNext != null && l.val == lNext.val) {
                judge = 1;
                lNext = lNext.next;
            }
            if (judge == 1) {
                pre.next = lNext;
                l = lNext;
            } else {
                pre = pre.next;
                l = l.next;
            }
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1),
                 l = head;

        for(int i = 0; i < 3; i++) {
            l.next = new ListNode(2);
            l = l.next;
        }
        for(int i = 1; i < 4; i++) {
            l.next = new ListNode(3);
            l = l.next;
        }
        for(int i = 3; i < 7; i++) {
            l.next = new ListNode(4);
            l = l.next;
        }
        l.next = new ListNode(5);
        head = deleteDuplicates(new ListNode(1));
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

