public class Solution {


    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>(),
                        s2 = new Stack<>();
        ListNode n1 = l1, n2 = l2;
        int cou1 = 0, cou2 = 0;
        while(n1 != null) {
            s1.push(n1);
            n1 = n1.next;
            cou1++;
        }
        while(n2 != null) {
            s2.push(n2);
            n2 = n2.next;
            cou2++;
        }
        int carry = 0;
        while(!s1.empty() && !s2.empty()) {
            ListNode node1 = s1.pop(),
                     node2 = s2.pop();
            int v = carry + node1.val + node2.val;
            carry = v / 10;
            node1.val = v % 10;
            node2.val = v % 10;
        }
        if(cou1 > cou2) {
            while(!s1.empty() && carry != 0) {
                ListNode node = s1.pop();
                int v = node.val + carry;
                node.val = v % 10;
                carry = v / 10;
            }
            if(s1.empty() && carry != 0) {
                ListNode newHead = new ListNode(1);
                newHead.next = l1;
                l1 = newHead;
            }
            return l1;
        } else {
            while(!s2.empty() && carry != 0) {
                ListNode node = s2.pop();
                int v = node.val + carry;
                node.val = v % 10;
                carry = v / 10;
            }
            if(s2.empty() && carry != 0) {
                ListNode newHead = new ListNode(1);
                newHead.next = l2;
                l2 = newHead;
            }
            return l2;
        }
    }
    
    //正确姿势
    
//    public class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        Stack<Integer> s1 = new Stack<Integer>();
//        Stack<Integer> s2 = new Stack<Integer>();
//        
//        while(l1 != null) {
//            s1.push(l1.val);
//            l1 = l1.next;
//        };
//        while(l2 != null) {
//            s2.push(l2.val);
//            l2 = l2.next;
//        }
//        
//        int sum = 0;
//        ListNode list = new ListNode(0);
//        while (!s1.empty() || !s2.empty()) {
//            if (!s1.empty()) sum += s1.pop();
//            if (!s2.empty()) sum += s2.pop();
//            list.val = sum % 10;
//            ListNode head = new ListNode(sum / 10);
//            head.next = list;
//            list = head;
//            sum /= 10;
//        }
//        
//        return list.val == 0 ? list.next : list;
//    }
//}