import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n < 0) return null;
        int len = 0;
        ListNode l = head;
        while(l != null) {
            len++;
            l = l.next;
        }
        int trueLen = len - n;
        if(trueLen == 0) return head.next;
        l = head;
        for(int i = 0; i < trueLen - 1; i++) {
            if(l == null && i < trueLen - 1) return null;
            l = l.next;
        }
        if(l.next == null) return head;
        l.next = l.next.next;
        return head;
    }
}
