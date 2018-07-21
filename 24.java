import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Input:
//    [1,2,3,4]
//Output:
//    [2,1,3]
//Expected:
//    [2,1,4,3]

public class Solution {
    static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head,
                 second = head.next,
                 pre = first;
        while(true) {
            if(first == head) head = second;
            else {
                pre.next = second;
                pre = first;
            }
            first.next = second.next;
            second.next = first;
            first = first.next;
            if(first == null || first.next == null) return head;
            second = first.next;
        }

    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1),
                 l = head;
        for(int i = 2; i < 5; i++) {
            l.next = new ListNode(i);
            l = l.next;
        }
        head = swapPairs(head);
        for(int i = 0; i < 4; i++) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
