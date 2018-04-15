class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l;
        if(l1 == null && l2 == null)
            return l1;
        else if(l1 == null){
            l = new ListNode(l2.val);
            l2 = l2.next;
        }
        else if(l2 == null){
            l = new ListNode(l1.val);
            l1 = l1.next;
        }  else if(l1.val < l2.val) {
            l = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            l = new ListNode(l2.val);
            l2= l2.next;
        }
        ListNode first =l;
        for(;l1 != null || l2 != null;) {
            if(l1 == null) {
                l.next = l2;
                if(l2.next == null)
                    return first;
                l2 = l2.next;
                l = l.next;
                continue;
            }
            if(l2 == null) {
                l.next = l1;
                if(l1.next == null)
                    return first;
                l1 =l1.next;
                l = l.next;
                continue;
            } 
            if(l1.val < l2.val) {
                l.next = l1;
                l1 = l1.next;
                
            }
            else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
            
        }
        return first;

    }
}