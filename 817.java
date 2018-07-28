import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


public class Solution {


    public int numComponents(ListNode head, int[] G) {
        Set<Integer> s = new HashSet<>();
        for(int x : G) s.add(x);
        ListNode cur = head;
        int ans = 0;
        while(cur != null) {
            if(s.contains(cur.val) &&
                    (cur.next == null || !s.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }
        return ans;
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

