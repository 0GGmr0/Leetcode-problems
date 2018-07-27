import org.w3c.dom.NodeList;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    static ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode newHead = new ListNode(head.val),
                 l = head.next;
        while(l != null) {
            ListNode temp = newHead,
                     node = new ListNode(l.val);
            if(l.val <= temp.val) {
                node.next = newHead;
                newHead = node;
            } else {
                while (temp.next != null && temp.next.val < l.val) temp = temp.next;
                node.next = temp.next;
                temp.next = node;
            }
            l = l.next;
        }
        return newHead;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            String s = sc.next();
            char[] a = s.toCharArray();
            ListNode head = new ListNode(a[0] - 48),
                    l = head;
            int len = a.length;
            for (int i = 1; i < len; i++) {
                l.next = new ListNode(a[i] - 48);
                l = l.next;
            }
            head = insertionSortList(head);

            while (head != null) {
                System.out.println(head.val);
                head = head.next;
            }
        }

    }
}

