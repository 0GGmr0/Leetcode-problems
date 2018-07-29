import java.util.*;


public class Solution {


    static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<ListNode> l = new ArrayList<>();
        while(head != null) {
            l.add(head);
            head = head.next;
        }
        int len = l.size();
        TreeNode t = new TreeNode(l.get(len/2).val);
        return sort(l, 0, len - 1);
    }

    static TreeNode sort(List<ListNode> s, int l, int r) {
        if(l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode t = new TreeNode(s.get(mid).val);
        t.left = sort(s, l, mid - 1);
        t.right =sort(s, mid + 1, r);
        return t;
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
            TreeNode root = sortedListToBST(head);
            System.out.print(root);
            //ListNode[] a = splitListToParts(head, 3);
//            for(int i = 0; i < a.length; i++) {
//                while(a[i] != null) {
//                    System.out.print(a[i].val + " ");
//                    a[i] = a[i].next;
//                }
//                System.out.println();
//            }

//            while (head != null) {
//                System.out.println(head.val);
//                head = head.next;
//            }
        }

    }
}

