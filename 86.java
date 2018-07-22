import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    static ListNode partition(ListNode head, int x) {
            if(head == null || head.next == null) return head;
            ListNode newHead = new ListNode(x - 1),
                     newRail = newHead,
                     temp = newHead,
                     l = head;
            int judge = 0;
            int count = 0;
            while(l != null) {
                ListNode node = new ListNode(l.val);
                if(l.val <= x - 1) {
                    node.next = temp.next;
                    if(judge == 0) {
                        newHead = node;
                        temp = newHead;
                        judge = 1;
                        if(count == 0) {
                            newRail = temp;
                        }
                        l = l.next;
                        while(l != null && l.val <= x - 1) {
                            ListNode node1 = new ListNode(l.val);
                            node1.next = temp.next;
                            temp.next = node1;
                            temp = node1;
                            if(count == 0){
                                newRail = temp;
                            }
                            l = l.next;
                        }

                    } else {
                        temp.next = node;
                        temp = node;
                        l = l.next;
                    }
                } else {
                    newRail.next = node;
                    newRail = node;
                    l = l.next;
                }
                count++;
            }
            if(judge == 0) newHead = newHead.next;
            return newHead;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(3),
                 l = head;
        l.next = new ListNode(3);
        l = l.next;
        l.next = new ListNode(1);
        l = l.next;
        l.next = new ListNode(2);
        l = l.next;
        l.next = new ListNode(4);
        l = l.next;
//        l.next = new ListNode(2);
//        l = l.next;


//        for(int i = 0; i < 3; i++) {
//            l.next = new ListNode(2);
//            l = l.next;
//        }
        head = partition(head, 3);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

