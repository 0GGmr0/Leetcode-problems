import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    static ListNode rotateRight(ListNode head, int k) {
        if(k < 0 || head == null) return null;
        ListNode l = head;
        int len = 0;
        ListNode rail = head;
        while(l != null) {
            len++;
            if(l.next == null)  rail = l;
            l = l.next;
        }
        int turnNum = k % len;
        int turnRight = len - turnNum;
        l = head;
        ListNode start = head;
        for(int i = 0; i < turnRight - 1; i++) start = start.next;
        rail.next = head;
        head = start.next;
        start.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0),
                 l = head;
        for(int i = 1; i < 3; i++) {
            l.next = new ListNode(i);
            l = l.next;
        }
        head = rotateRight(head, 4);
        for(int i = 0; i < 3; i++) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
