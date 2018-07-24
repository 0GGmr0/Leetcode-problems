import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l = head.next.next,
                odd = head,
                even = head.next;
        int count = 3;
        while(l != null) {
            ListNode node = l;
            l = l.next;
            if(count % 2 == 1) {
                even.next = l;
                node.next = odd.next;
                odd.next = node;
                odd = node;
            } else {
                even = node;
            }
            count++;
        }

        return head;
    }
//        //一开始就是偶数,找到第一个不是偶数的当做首位，然后开始遍历剩下的内容
//        if(l.val % 2 == 0) {
//            while(l != null && l.val % 2 == 0) {
//                even = l;
//                l = l.next;
//            }
//            if(l != null) {
//                even.next = l.next;
//                l.next = head;
//                head = l;
//                odd = head;
//                l = even.next;
//            }
//        } else {
//            //一开始就是奇数，找到第一个不是奇数的即可
//            while(l != null && l.val % 2 == 1) {
//                odd = l;
//                l = l.next;
//            }
//            if(l != null) {
//                even = l;
//                l = l.next;
//            }
//        }
//
//        while(l != null) {
//            ListNode node = l;
//            l = l.next;
//            if(node.val % 2 == 1) {
//                even.next = l;
//                node.next = odd.next;
//                odd.next = node;
//                odd = node;
//            } else {
//                even = node;
//            }
//        }
//        return head;
//    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1),
                 l = head;

//        l.next = new ListNode(1);
//        l = l.next;
//        l.next = new ListNode(3);
//        l = l.next;
//        l.next = new ListNode(5);
//        l = l.next;
//        l.next = new ListNode(6);
//        l = l.next;
//        l.next = new ListNode(4);
//        l = l.next;
//        l.next = new ListNode(7);
//        l = l.next;

        for(int i = 2; i < 6; i++) {
            l.next = new ListNode(i);
            l = l.next;
        }
        head = oddEvenList(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

