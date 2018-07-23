import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    static ListNode detectCycle(ListNode head) {
        ListNode fast = head,
                 slow = head,
                 entry = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while(slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1),
                 l = head;
        l.next = head;

//        l.next = new ListNode(2);
//        l = l.next;


//        for(int i = 0; i < 3; i++) {
//            l.next = new ListNode(2);
//            l = l.next;
//        }
        head = detectCycle(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

