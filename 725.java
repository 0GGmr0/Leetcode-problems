import java.util.Scanner;
import java.util.Stack;


public class Solution {


    static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ls = new ListNode[k];
        ListNode l = root;
        int len = 0;
        while(l != null) {
            len++;
            l = l.next;
        }
        l = root;
        if(k >= len) {
            for(int i = 0; i < len; i++, l = l.next) ls[i] = new ListNode(l.val);
        } else {
            int[] a = new int[k];
            int p = len / k;
            for(int i = 0; i < k; i++) a[i] = p;
            int modp = len % k;
            for(int i = 0; i < modp; i++) a[i]++;
            for(int i = 0; i < k; i++) {
                ls[i] = l;
                for(int j = 0; j < a[i] - 1; j++) l = l.next;
                ListNode node = l.next;
                l.next = null;
                l = node;
            }
        }
        return ls;
    }


    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] c = s.split("\\s+");
            int size = c.length;
            int[] b =new int[size];
            for (int m = 0; m < b.length; m++) {
                b[m] = Integer.parseInt(c[m]);
            }
            ListNode head = new ListNode(b[0]),
                    l = head;
            for (int i = 1; i < size; i++) {
                l.next = new ListNode(b[i]);
                l = l.next;
            }
            ListNode[] a = splitListToParts(head, 3);
            for(int i = 0; i < a.length; i++) {
                while(a[i] != null) {
                    System.out.print(a[i].val + " ");
                    a[i] = a[i].next;
                }
                System.out.println();
            }

//            while (head != null) {
//                System.out.println(head.val);
//                head = head.next;
//            }
        }

    }
}

