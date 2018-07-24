import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null ) return null;
        int count = 0;
        int len = n - m;
        ListNode l = head,
                 re = new ListNode(-12);
        re.next = head;
        head = re;
        l = head;
        while(++count < m) l = l.next;
        ListNode newNodeList = l.next, //翻转起点
                 tempRail  = l.next,  //翻转终点
                 temp = l;  //要翻转位置之前的结点
        if(l.next != null && l.next.next != null) l = l.next.next;
        int judge = 0;
        for(int i = 0; i < len; i++) {
            ListNode node = new ListNode(l.val);
            node.next = newNodeList;
            newNodeList = node;
            l = l.next;
            judge = 1;
        }
        if(judge == 1) {
            tempRail.next = l;
            temp.next = newNodeList;
        }
        return head.next;
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
        head = reverseBetween(head, 2, 4);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

