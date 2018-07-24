import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    static void reorderList(ListNode head) {
        if(head == null) return;
        ListNode l = head;
        int len = 0;
        while(l != null) {
            len++;
            l = l.next;
        }
        l = head;
        int left= (len + 1) / 2;
        ListNode temp = l;
        for(int i  = 0; i < left; i++) {
            if(i == left - 1) temp = l;
            l = l.next;
        }
        temp.next = null;
        Stack<ListNode> stack = new Stack<>();
        while(l != null) {
            stack.push(new ListNode(l.val));
            l = l.next;
        }
        l = head;
        while(!stack.empty()) {
            ListNode node = stack.pop();
            node.next = l.next;
            l.next = node;
            l = l.next.next;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1),
                 l = head;

//        l.next = new ListNode(5);
////        l = l.next;


        for(int i = 2; i < 6; i++) {
            l.next = new ListNode(i);
            l = l.next;
        }
        reorderList(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

