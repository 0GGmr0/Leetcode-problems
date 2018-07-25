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

